package com.nearbites.controller;

import com.nearbites.model.Item;
import com.nearbites.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins = { "http://localhost:8081" })
@RestController
@RequestMapping("/items")
public class ItemController {

    @Autowired
    ItemRepository itemRepository;

    @GetMapping("/allItemsUserAccount")
    public ResponseEntity<List<Item>> getAllItems() {
        List<Item> items = new ArrayList<>();

        itemRepository.findAll().forEach(items::add);
        return new ResponseEntity<>(items, HttpStatus.OK);
    }

    @PostMapping("/additem")
    public ResponseEntity<Item> createItem(@RequestBody Item item) {
        try {
            Item _item = itemRepository.save(new Item(item.getOwnerId(), item.getName(), item.getPrice(), item.getQuantity(), item.getExtraInfo(),
                    item.getPhotos(), item.getReviews()));
            return new ResponseEntity<>(_item, HttpStatus.CREATED);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return new ResponseEntity<>((Item) null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
