package com.nearbites.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.net.URL;
import java.util.List;

@Document(collection = "items")
public class Item {

    @Id
    private String id;
    private String ownerId;
    private String name;
    private Double price;
    private String quantity;
    private String desc;
    private ExtraInfo extraInfo;
    private List<String> photos;
    private List<Review> reviews;

    public Item() {

    }

    public Item(String ownerId, String name, Double price, String quantity, String desc, ExtraInfo extraInfo, List<String> photos, List<Review> reviews) {
        this.ownerId = ownerId;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.desc = desc;
        this.extraInfo = extraInfo;
        this.photos = photos;
        this.reviews = reviews;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(String ownerId) {
        this.ownerId = ownerId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public String getDesc() { return desc; }

    public void setDesc(String desc) { this.desc = desc; }

    public ExtraInfo getExtraInfo() {
        return extraInfo;
    }

    public void setExtraInfo(ExtraInfo extraInfo) {
        this.extraInfo = extraInfo;
    }

    public List<String> getPhotos() {
        return photos;
    }

    public void setPhotos(List<String> photos) {
        this.photos = photos;
    }

    public void addPhotos(List<String> photos) {
        this.photos.addAll(photos);
    }

    public List<Review> getReviews() {
        return reviews;
    }

    public void setReviews(List<Review> reviews) {
        this.reviews = reviews;
    }

    public void addReview(Review review) {this.reviews.add(0, review);}

}
