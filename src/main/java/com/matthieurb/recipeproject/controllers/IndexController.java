package com.matthieurb.recipeproject.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.matthieurb.recipeproject.services.RecipeService;

@Controller
public class IndexController {

	private RecipeService recipeService;

	public IndexController(RecipeService recipeService) {
		this.recipeService = recipeService;
	}
	
	@RequestMapping({"index","","/","index.html"})
	public String getIndexPage(Model model) {
		model.addAttribute("recipes", recipeService.getAllRecipes());
		return "index";
	}

}
