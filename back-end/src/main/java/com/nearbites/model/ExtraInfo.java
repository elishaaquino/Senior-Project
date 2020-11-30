package com.nearbites.model;

import java.util.List;

public class ExtraInfo {
    private List<String> allergens;
    private List<String> dietaryRestric;


    public ExtraInfo() {

    }

    public ExtraInfo(List<String> allergens, List<String> dietaryRestric) {
        this.allergens = allergens;
        this.dietaryRestric = dietaryRestric;

    }

    public List<String> getAllergens() {
        return allergens;
    }

    public void setAllergens(List<String> allergens) {
        this.allergens = allergens;
    }

    public List<String> getDietaryRestric() {
        return dietaryRestric;
    }

    public void setDietaryRestric(List<String>  dietaryRestric) {
        this.dietaryRestric = dietaryRestric;
    }
}
