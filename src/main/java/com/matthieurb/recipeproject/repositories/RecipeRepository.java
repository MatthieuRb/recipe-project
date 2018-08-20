package com.matthieurb.recipeproject.repositories;

import org.springframework.data.repository.CrudRepository;

import com.matthieurb.recipeproject.domain.Recipe;

public interface RecipeRepository extends CrudRepository<Recipe, Long>{

}