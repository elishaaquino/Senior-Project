package com.nearbites.controller;

import com.nearbites.model.*;
import com.nearbites.repository.ItemRepository;
import com.nearbites.repository.RoleRepository;
import com.nearbites.repository.UserRepository;
import com.nearbites.service.authentication.UserDetailsImpl;
import com.nearbites.util.JwtResponse;
import com.nearbites.util.JwtUtils;
import com.nearbites.util.LoginRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.*;
import java.util.stream.Collectors;

@CrossOrigin(origins = { "http://localhost:8081" })
@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    ItemRepository itemRepository;

    @Autowired
    PasswordEncoder encoder;

    @Autowired
    JwtUtils jwtUtils;

    @PostMapping("/signup")
    public ResponseEntity<?> registerUser(@RequestBody User user) {
        if (userRepository.existsByUsername(user.getUsername())) {
            return ResponseEntity
                    .badRequest()
                    .body("Error: Username is already taken!");
        }

        // Create new user's account
        User newUser = new User(user.getUsername(), encoder.encode(user.getPassword()),
                user.getFirstName(), user.getLastName(), user.getContact(), user.getImageUrl(), new ArrayList<>());

        Set<Role> roles = new HashSet<>();
        Role role = new Role(ERole.ROLE_USER);
        roles.add(role);

        newUser.setRoles(roles);
        userRepository.save(newUser);

        return ResponseEntity.ok("User registered successfully!");
    }

    @PostMapping("/signin")
    public ResponseEntity<?> authenticateUser(@RequestBody LoginRequest request) {

        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtUtils.generateJwtToken(authentication);

        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
        List<String> roles = userDetails.getAuthorities().stream()
                .map(item -> item.getAuthority())
                .collect(Collectors.toList());

        return ResponseEntity.ok(new JwtResponse(jwt,
                userDetails.getId(),
                userDetails.getUsername(),
                roles));
    }

    @PostMapping("/logout")
    @PreAuthorize("hasRole('ROLE_USER')")
    public ResponseEntity logoutUser() {
        SecurityContext securityContext = SecurityContextHolder.getContext();
        securityContext.setAuthentication(null);
        return ResponseEntity.ok("logout successful");
    }

    @GetMapping("/users")
    public ResponseEntity<List<User>> getAllUsers() {
        List<User> users = new ArrayList<>();

        userRepository.findAll().forEach(users::add);
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @PutMapping("/addReview/{id}")
    public ResponseEntity<User> addReviewForUser(@RequestBody Review review, @PathVariable String id) {
        try {
            Item _item = itemRepository.findById(id)
                    .orElseThrow(() -> new Exception("Item not found with id: " + id));
            User _user = userRepository.findById(_item.getOwnerId())
                    .orElseThrow(() -> new Exception("User not found for item with id: " + id));

            _user.addReview(review);
            _user = userRepository.save(_user);

            return new ResponseEntity<>(_user, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>((User) null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}