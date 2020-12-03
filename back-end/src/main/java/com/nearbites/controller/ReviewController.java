package com.nearbites.controller;

import com.nearbites.model.Review;
import com.nearbites.repository.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.Date;

@CrossOrigin(origins = { "http://localhost:8081" })
@RestController
public class ReviewController {

    @Autowired
    ReviewRepository reviewRepository;

    @PostMapping("/reviews")
    public ResponseEntity<Review> createReview(@RequestBody Review review) {
        try {
            Date date = new Date();
            SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
            Review _review = reviewRepository.save(new Review(review.getUsername(),
                    review.getReview(), formatter.format(date)));
            return new ResponseEntity<>(_review, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>((Review) null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
