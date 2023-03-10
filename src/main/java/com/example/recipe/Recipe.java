// Write your code here
package com.example.recipe;
import java.util.*;

public class Recipe{
    private int recipeId;
    private String recipeName;
    private String recipeType;
    private Collection<String> ingredients;

    public Recipe(int recipeId, String recipeName, String recipeType, Collection<String> ingredients){
        this.recipeId = recipeId;
        this.recipeName = recipeName;
        this.recipeType = recipeType;
        this.ingredients = ingredients;
    }

    public int getRecipeId(){
        return this.recipeId;
    }

    public void setRecipeId(int recipeId){
        this.recipeId = recipeId;
    }
    public String getRecipeName(){
        return this.recipeName;
    }
    public void setRecipeName(String recipeName){
        this.recipeName = recipeName;
    }
    public String getRecipeType(){
        return this.recipeType;
    }
    public void setRecipeType(String recipeType){
        this.recipeType = recipeType;
    }
    public Collection<String> getIngredients(){
        return this.ingredients;
    }
    public void setIngredients(Collection<String> ingredients){
        this.ingredients = ingredients;
    }
}