package com.mc.jaspfood;

public class Food {

    private String description;
    private String imagePath;
    private String votes;

    public Food(String imagePath, String description, String votes) {
        this.imagePath = imagePath;
        this.description = description;
        this.votes = votes;
    }

    public Food(String imagePath, String description) {
        this.imagePath = imagePath;
        this.description = description;
        this.votes = votes;
    }

    public String getDescription() {
        return description;
    }

    public String getImagePath() {
        return imagePath;
    }

    public String getVotes() { return votes; }

}