package com.nearbites.repository;

import com.nearbites.model.Item;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface ItemRepository extends MongoRepository<Item, String> {
    List<Item> findByOwnerId(String ownerId);
}
