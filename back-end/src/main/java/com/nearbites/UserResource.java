package com.nearbites;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin(origins = { "http://localhost:8081" })
@RestController
public class UserResource {

    @Autowired
    private UsersHardcodedService userManagementService;

    @GetMapping("/users")
    public List<User> getAllUsers() {
        return userManagementService.findAll();
    }
}