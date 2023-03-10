package com.example.recipe;

import org.springframework.web.server.ResponseStatusException;
import org.springframework.http.HttpStatus;

import com.example.recipe.RecipeRepository;
import com.example.recipe.Recipe;


import java.util.*;

// Don't modify the below code

public class RecipeService implements RecipeRepository {

        private static HashMap<Integer, Recipe> recipeBook = new HashMap<>();

        public RecipeService() {
                recipeBook.put(1,
                                new Recipe(1, "Pasta", "veg",
                                                Arrays.asList("pasta", "tomatoes", "olive oil", "garlic", "basil")));
                recipeBook.put(2, new Recipe(2, "Chicken Curry", "non-veg",
                                Arrays.asList("chicken", "onion", "tomato", "ginger", "garlic", "spices")));
                recipeBook.put(3, new Recipe(3, "Sushi", "non-veg",
                                Arrays.asList("sushi rice", "tuna fish", "seaweed", "wasabi", "ginger")));
                recipeBook.put(4, new Recipe(4, "Mushroom Risotto", "veg",
                                Arrays.asList("rice", "mushrooms", "onion", "garlic", "butter", "parmesan")));
                recipeBook.put(5, new Recipe(5, "Fish and Chips", "non-veg",
                                Arrays.asList("fish", "potatoes", "flour", "oil", "spices")));
        }

        // Don't modify the above code

        // Write your code here
        int uniqueId = 6;
        @Override
        public ArrayList<Recipe> getRecipes(){
                Collection<Recipe> recipeCollection = recipeBook.values();
                ArrayList<Recipe> recipes = new ArrayList<>(recipeCollection);
                return recipes;
        }
        @Override
        public Recipe addRecipe(Recipe recipe){
                recipe.setRecipeId(uniqueId);
                recipeBook.put(uniqueId,recipe);
                uniqueId += 1;
                return recipe;
        }
        @Override
        public Recipe getRecipeById(int recipeId){
                Recipe r = recipeBook.get(recipeId);
                if(r == null){
                        throw new ResponseStatusException(HttpStatus.NOT_FOUND);
                }
                return r;
        }
        @Override
        public Recipe updateRecipe(Recipe recipe, int recipeId){
                Recipe existing_recipe = recipeBook.get(recipeId);
                if(existing_recipe == null){
                        throw new ResponseStatusException(HttpStatus.NOT_FOUND);
                }
                if(existing_recipe.getRecipeName() != null){
                        if(recipe.getRecipeName() != null){
                                existing_recipe.setRecipeName(recipe.getRecipeName());
                        }
                }
                if(existing_recipe.getRecipeType() != null){
                        if(recipe.getRecipeType() != null){
                                existing_recipe.setRecipeType(recipe.getRecipeType());
                        }
                }
                if(existing_recipe.getIngredients() != null){
                        if(recipe.getIngredients() != null){
                                existing_recipe.setIngredients(recipe.getIngredients());
                        }
                }
                return existing_recipe;
        }
        @Override
        public void deleteRecipe(int recipeId){
                Recipe rs = recipeBook.get(recipeId);
                if(rs == null){
                        throw new ResponseStatusException(HttpStatus.NOT_FOUND);
                }
                else{
                        recipeBook.remove(recipeId);
                        throw new ResponseStatusException(HttpStatus.NO_CONTENT);
                }
        }
}