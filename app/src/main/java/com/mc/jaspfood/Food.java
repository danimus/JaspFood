package com.mc.jaspfood;

public class Food {

    private String description;

    private String imagePath;

    public Food(String imagePath, String description) {
        this.imagePath = imagePath;
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public String getImagePath() {
        return imagePath;
    }

}