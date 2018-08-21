package com.matthieurb.recipeproject.services.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import org.springframework.stereotype.Service;

import com.matthieurb.recipeproject.domain.Ingredient;
import com.matthieurb.recipeproject.domain.Recipe;
import com.matthieurb.recipeproject.repositories.RecipeRepository;
import com.matthieurb.recipeproject.repositories.UnitOfMeasureRepository;
import com.matthieurb.recipeproject.services.RecipeService;

@Service
public class RecipeServiceImpl implements RecipeService {
	
	private RecipeRepository recipeRepository;
	private UnitOfMeasureRepository unitOfMeasureRepository;
	
	public RecipeServiceImpl(RecipeRepository recipeRepository, UnitOfMeasureRepository unitOfMeasureRepository) {
		this.recipeRepository = recipeRepository;
		this.unitOfMeasureRepository = unitOfMeasureRepository;
	}

	@Override
	public Set<Recipe> getAllRecipes() {
		Set<Recipe> recipes = new HashSet<Recipe>();
		recipeRepository.findAll().iterator().forEachRemaining(recipes::add);
		return  recipes;
	}
	
	@Override
	public Ingredient addIngredientToRecipe(Recipe recipe, String description, String amount, String unit) {
		Ingredient ingredient = new Ingredient();
		ingredient.setRecipe(recipe);
		ingredient.setAmount(new BigDecimal(amount));
		ingredient.setDescription(description);
		if(unit != null) {
			ingredient.setUnit(unitOfMeasureRepository.findByUnit(unit).get());
		}
		recipe.getIngredients().add(ingredient);
		return ingredient;
	}

}
