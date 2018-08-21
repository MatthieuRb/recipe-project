package com.matthieurb.recipeproject.services;

import java.util.Set;

import com.matthieurb.recipeproject.domain.Ingredient;
import com.matthieurb.recipeproject.domain.Recipe;

public interface RecipeService {
	
	public Set<Recipe> getAllRecipes();
	public Ingredient addIngredientToRecipe(Recipe recipe, String description, String amount, String unit);

}
