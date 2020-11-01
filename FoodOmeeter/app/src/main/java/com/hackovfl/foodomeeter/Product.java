package com.hackovfl.foodomeeter;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Product implements Serializable {
    private String email;
    private String name;
    private String score;
    private List<Ingredient> ingredients = new ArrayList<>();

    public Product(String name, String score, List<Ingredient> ingredients, String email) {
        this.name = name;
        this.score = score;
        this.ingredients = ingredients;
        this.email=email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
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

    public List<Ingredient> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }

    @Override
    public String toString() {
        return
                  name + '\'' +
                " score= " + score + '\'' + "\n" + "\n";
    }
}
