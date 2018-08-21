package com.matthieurb.recipeproject.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.matthieurb.recipeproject.domain.Difficulty;
import com.matthieurb.recipeproject.domain.Notes;
import com.matthieurb.recipeproject.domain.Recipe;
import com.matthieurb.recipeproject.repositories.CategoryRepository;
import com.matthieurb.recipeproject.repositories.RecipeRepository;
import com.matthieurb.recipeproject.services.RecipeService;

@Component
public class DataLoader implements CommandLineRunner {
	
	private RecipeRepository recipeRepository;
	private CategoryRepository categoryRepository;
	private RecipeService recipeService;

	public DataLoader(RecipeRepository recipeRepository, CategoryRepository categoryRepository, RecipeService recipeService) {
		this.recipeRepository = recipeRepository;
		this.categoryRepository = categoryRepository;
		this.recipeService = recipeService;
	}

	@Override
	public void run(String... args) throws Exception {
		loadData();
	}
	
	public void loadData() {
		
		Recipe guacamole = new Recipe();
		
		recipeService.addIngredientToRecipe(guacamole, "avocados","2","Ripe");
		recipeService.addIngredientToRecipe(guacamole, "kosher salt","0.5","Teaspoon");
		recipeService.addIngredientToRecipe(guacamole, "fresh lime juice or lemon juice","1","Tablespoon");		
		recipeService.addIngredientToRecipe(guacamole, "of minced red onion or thinly sliced green onion","2","Tablespoon");		
		recipeService.addIngredientToRecipe(guacamole, "serrano chiles, stems and seeds removed, minced","1",null);
		recipeService.addIngredientToRecipe(guacamole, "cilantro (leaves and tender stems), finely chopped","2","Tablespoon");
		recipeService.addIngredientToRecipe(guacamole, "of freshly grated black pepper","1","Dash");
		recipeService.addIngredientToRecipe(guacamole, "tomato, seeds and pulp removed, chopped","0.5","Ripe");
		
		guacamole.getCategories().add(categoryRepository.findByDescription("Mexican").get());
		guacamole.getCategories().add(categoryRepository.findByDescription("Fast Food").get());
		
		guacamole.setCookTime(0);
		guacamole.setDescription("How to Make Perfect Guacamole Recipe");
		guacamole.setDifficulty(Difficulty.EASY);
		guacamole.setDirection("Direction");
		guacamole.setImage("/resources/images/guacamole-horiz-a-1600.jpg");
		
		Notes notesGuacamole = new Notes();
		notesGuacamole.setRecipe(guacamole);
		notesGuacamole.setRecipeNotes("1 Cut avocado, remove flesh: Cut the avocados in half. Remove seed. Score the inside of the avocado with a blunt knife and scoop out the flesh with a spoon. (See How to Cut and Peel an Avocado.) Place in a bowl.\r\n" + 
				"\r\n" + 
				"\r\n" + 
				"\r\n" + 
				"2 Mash with a fork: Using a fork, roughly mash the avocado. (Don't overdo it! The guacamole should be a little chunky.)\r\n" + 
				"\r\n" + 
				"\r\n" + 
				"\r\n" + 
				"3 Add salt, lime juice, and the rest: Sprinkle with salt and lime (or lemon) juice. The acid in the lime juice will provide some balance to the richness of the avocado and will help delay the avocados from turning brown.\r\n" + 
				"\r\n" + 
				"Add the chopped onion, cilantro, black pepper, and chiles. Chili peppers vary individually in their hotness. So, start with a half of one chili pepper and add to the guacamole to your desired degree of hotness.\r\n" + 
				"\r\n" + 
				"Remember that much of this is done to taste because of the variability in the fresh ingredients. Start with this recipe and adjust to your taste.\r\n" + 
				"\r\n" + 
				"4 Cover with plastic and chill to store: Place plastic wrap on the surface of the guacamole cover it and to prevent air reaching it. (The oxygen in the air causes oxidation which will turn the guacamole brown.) Refrigerate until ready to serve.\r\n" + 
				"\r\n" + 
				"Chilling tomatoes hurts their flavor, so if you want to add chopped tomato to your guacamole, add it just before serving.\r\n" + 
				"\r\n" + 
				"Variations\r\n" + 
				"\r\n" + 
				"For a very quick guacamole just take a 1/4 cup of salsa and mix it in with your mashed avocados.\r\n" + 
				"\r\n" + 
				"Feel free to experiment! One classic Mexican guacamole has pomegranate seeds and chunks of peaches in it (a Diana Kennedy favorite). Try guacamole with added pineapple, mango, or strawberries (see our Strawberry Guacamole).\r\n" + 
				"\r\n" + 
				"The simplest version of guacamole is just mashed avocados with salt. Don't let the lack of availability of other ingredients stop you from making guacamole.\r\n" + 
				"\r\n" + 
				"To extend a limited supply of avocados, add either sour cream or cottage cheese to your guacamole dip. Purists may be horrified, but so what? It tastes great.\r\n" + 
				"\r\n" + 
				"For a deviled egg version with guacamole, try our Guacamole Deviled Eggs!");
		
		guacamole.setNotes(notesGuacamole);
		guacamole.setPrepTime(10);
		guacamole.setServings(3);
		guacamole.setSource("Elise Bauer");
		guacamole.setUrl("https://www.simplyrecipes.com/recipes/perfect_guacamole/");
		
		recipeRepository.save(guacamole);
		
		Recipe chicken = new Recipe();
		
		recipeService.addIngredientToRecipe(chicken, "ancho chili powder","2","Tablespoon");
		recipeService.addIngredientToRecipe(chicken, "dried oregano","1","Teaspoon");
		recipeService.addIngredientToRecipe(chicken, "dried cumin","1","Teaspoon");
		recipeService.addIngredientToRecipe(chicken, "sugar","1","Teaspoon");
		recipeService.addIngredientToRecipe(chicken, "salt","0.5","Teaspoon");
		recipeService.addIngredientToRecipe(chicken, "garlic, finely chopped","1","Clove");
		recipeService.addIngredientToRecipe(chicken, "finely grated orange zest","1","Tablespoon");
		recipeService.addIngredientToRecipe(chicken, "fresh-squeezed orange juice","3","Tablespoon");
		recipeService.addIngredientToRecipe(chicken, "olive oil","2","Tablespoon");
		recipeService.addIngredientToRecipe(chicken, "skinless, boneless chicken thighs","4",null);
		
		chicken.getCategories().add(categoryRepository.findByDescription("Mexican").get());
		chicken.getCategories().add(categoryRepository.findByDescription("Fast Food").get());
		
		chicken.setCookTime(15);
		chicken.setDescription("Spicy Grilled Chicken Tacos Recipe");
		chicken.setDifficulty(Difficulty.EASY);
		chicken.setDirection("Direction");
		chicken.setImage("/resources/images/2017-05-29-GrilledChickenTacos-2.jpg");
		
		Notes notesChicken = new Notes();
		notesChicken.setRecipe(chicken);
		notesChicken.setRecipeNotes("1 Prepare a gas or charcoal grill for medium-high, direct heat.\r\n" + 
				"\r\n" + 
				"2 Make the marinade and coat the chicken: In a large bowl, stir together the chili powder, oregano, cumin, sugar, salt, garlic and orange zest. Stir in the orange juice and olive oil to make a loose paste. Add the chicken to the bowl and toss to coat all over.\r\n" + 
				"\r\n" + 
				"Set aside to marinate while the grill heats and you prepare the rest of the toppings.\r\n" + 
				"\r\n" + 
				"Spicy Grilled Chicken Tacos\r\n" + 
				"\r\n" + 
				"3 Grill the chicken: Grill the chicken for 3 to 4 minutes per side, or until a thermometer inserted into the thickest part of the meat registers 165F. Transfer to a plate and rest for 5 minutes.\r\n" + 
				"\r\n" + 
				"4 Warm the tortillas: Place each tortilla on the grill or on a hot, dry skillet over medium-high heat. As soon as you see pockets of the air start to puff up in the tortilla, turn it with tongs and heat for a few seconds on the other side.\r\n" + 
				"\r\n" + 
				"Wrap warmed tortillas in a tea towel to keep them warm until serving.\r\n" + 
				"\r\n" + 
				"5 Assemble the tacos: Slice the chicken into strips. On each tortilla, place a small handful of arugula. Top with chicken slices, sliced avocado, radishes, tomatoes, and onion slices. Drizzle with the thinned sour cream. Serve with lime wedges.");
		
		chicken.setNotes(notesChicken);
		chicken.setPrepTime(20);
		chicken.setServings(5);
		chicken.setSource("Sally Vargas");
		chicken.setUrl("https://www.simplyrecipes.com/recipes/spicy_grilled_chicken_tacos/");
		
		recipeRepository.save(chicken);
	}

}
