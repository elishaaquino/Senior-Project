package com.nearbites.controller;

import com.nearbites.model.Item;
import com.nearbites.model.Review;
import com.nearbites.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins = { "http://localhost:8081" })
@RestController
public class ItemController {

    @Autowired
    ItemRepository itemRepository;

    @GetMapping("/items")
    public ResponseEntity<List<Item>> getAllItems() {
        List<Item> items = new ArrayList<>();

        itemRepository.findAll().forEach(items::add);
        return new ResponseEntity<>(items, HttpStatus.OK);
    }

    @PostMapping("/items")
    public ResponseEntity<Item> createItem(@RequestBody Item item) {
        try {
            Item _item = itemRepository.save(new Item(item.getOwnerId(), item.getName(), item.getPrice(), item.getQuantity(), item.getExtraInfo(),
                    item.getPhotos(), item.getReviews()));
            return new ResponseEntity<>(_item, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>((Item) null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/itemReviews/{id}")
    public ResponseEntity<Item> addReviewForItem(@RequestBody Review review, @PathVariable String id) {
        try {
            Item _item = itemRepository.findById(id)
            .orElseThrow(() -> new Exception("Item not found with id: " + id));
            List<Review> _reviews = _item.getReviews();
            //if there are no reviews yet
            if(_reviews.get(0) != null) {
                _reviews.add(review);
                _item.setReviews(_reviews);
            }
            else {
                _reviews.set(0, review);
                _item.setReviews(_reviews);
            }
            _item = itemRepository.save(_item);
            return new ResponseEntity<>(_item, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>((Item) null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
