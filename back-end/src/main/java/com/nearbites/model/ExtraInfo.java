package com.nearbites.model;

import java.util.List;

public class ExtraInfo {
    private String allergens;
    private String dietaryRestric;


    public ExtraInfo() {

    }

    public ExtraInfo(String allergens, String dietaryRestric) {
        this.allergens = allergens;
        this.dietaryRestric = dietaryRestric;

    }

    public String getAllergens() {
        return allergens;
    }

    public void setAllergens(String allergens) {
        this.allergens = allergens;
    }

    public String getDietaryRestric() {
        return dietaryRestric;
    }

    public void setDietaryRestric(String dietaryRestric) {
        this.dietaryRestric = dietaryRestric;
    }
}
