package com.nearbites.controller;

import com.nearbites.model.Item;
import com.nearbites.model.Review;
import com.nearbites.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@CrossOrigin(origins = { "http://localhost:8081" })
@RestController
@RequestMapping("/items")
public class ItemController {

    @Autowired
    ItemRepository itemRepository;

    @GetMapping("")
    public ResponseEntity<List<Item>> getAllItems() {
        List<Item> items = new ArrayList<>();

        itemRepository.findAll().forEach(items::add);
        return new ResponseEntity<>(items, HttpStatus.OK);
    }

    @PostMapping("/additem")
    public ResponseEntity<Item> createItem(@RequestBody Item item) {
        try {
            Item _item = itemRepository.save(new Item(item.getOwnerId(), item.getName(), item.getPrice(), item.getQuantity(), item.getExtraInfo(),
                    item.getPhotos(), new ArrayList<>()));
            return new ResponseEntity<>(_item, HttpStatus.CREATED);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return new ResponseEntity<>((Item) null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/allItemsUserAccount")
    public ResponseEntity<List<Item>> getAllItemsUserAccount(@RequestParam String ownerId) {
        List<Item> items;

        items = itemRepository.findByOwnerId(ownerId);

        return new ResponseEntity<>(items, HttpStatus.OK);
    }

    @GetMapping("/allItemsStorePage/{id}")
    public ResponseEntity<List<Item>> getAllItemsStorePage(@PathVariable String id) {
        List<Item> items;

        items = itemRepository.findByOwnerId(id);

        return new ResponseEntity<>(items, HttpStatus.OK);
    }

    @PutMapping("/itemReviews/{id}")
    public ResponseEntity<Item> addReviewForItem(@RequestBody Review review, @PathVariable String id) {
        try {
            Date date = new Date();
            SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");

            Item _item = itemRepository.findById(id)
            .orElseThrow(() -> new Exception("Item not found with id: " + id));

            _item.addReview(new Review(Integer.toString(_item.getReviews().size() + 1), review.getUsername(),
                    review.getReview(), formatter.format(date), review.getUserImage()));
            _item = itemRepository.save(_item);

            return new ResponseEntity<>(_item, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>((Item) null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getInfoForItem(@PathVariable String id) {
        try {
            Item _item = itemRepository.findById(id)
                    .orElseThrow(() -> new Exception("Item not found with id: " + id));
            return new ResponseEntity<>(_item, HttpStatus.CREATED);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/search/{keyword}")
    public ResponseEntity<?> findItemByKeyword(@PathVariable String keyword) {
        try {
            List<Item> items = new ArrayList<>();
            
            itemRepository.findAll().forEach(item -> {
                if (item.getName().toLowerCase().contains(keyword.toLowerCase()))
                    items.add(item);
            });

            return new ResponseEntity<>(items, HttpStatus.OK);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
