package com.hackovfl.foodomeeter;

import java.io.Serializable;

public class Ingredient implements Serializable {
    private String name;
    private String score;
    private String description;

    public Ingredient(String name, String score, String description) {
        this.name = name;
        this.score = score;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Ingredient{" +
                "name='" + name + '\'' +
                ", score='" + score + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
