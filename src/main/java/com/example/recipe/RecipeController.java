package com.example.recipe;
import org.springframework.web.bind.annotation.*;
import java.util.*;
import com.example.recipe.RecipeService;

// Write your code here
@RestController
public class RecipeController{
    RecipeService rS = new RecipeService();

    @GetMapping("/recipes")
    public ArrayList<Recipe> getRecipes(){
        return rS.getRecipes();
    }
    @PostMapping("/recipes")
    public Recipe addRecipe(@RequestBody Recipe recipe){
        return rS.addRecipe(recipe);
    }
    @GetMapping("/recipes/{recipeId}")
    public Recipe getRecipeById(@PathVariable("recipeId") int recipeId){
        return rS.getRecipeById(recipeId);
    }
    @PutMapping("/recipes/{recipeId}")
    public Recipe updateRecipe(@RequestBody Recipe recipe,@PathVariable("recipeId") int recipeId){
        return rS.updateRecipe(recipe,recipeId);
    }
    @DeleteMapping("/recipes/{recipeId}")
    public void deleteRecipe(@PathVariable("recipeId") int recipeId){
        rS.deleteRecipe(recipeId);
    }
}