package guru.springframework.controllers;

import guru.springframework.commands.RecipeCommand;
import guru.springframework.domain.Recipe;
import guru.springframework.services.RecipeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by jt on 6/19/17.
 */
@Controller
public class RecipeController {

    private final RecipeService recipeService;

    public RecipeController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @GetMapping
    @RequestMapping("/recipe/{id}/show")
    public String showById(@PathVariable String id, Model model){

        model.addAttribute("recipe", recipeService.findById(new Long(id)));

        return "recipe/show";
    }
    
    @GetMapping
    @RequestMapping("/recipe/new")
    public String newRecipe(Model model) {
    	model.addAttribute("recipe", new RecipeCommand());
    	return "recipe/recipeform";
    }
    
    @GetMapping
    @RequestMapping("recipe/{id}/update")
    public String updateRecipe(Model model, @PathVariable String id) {
    	model.addAttribute("recipe", recipeService.findCommandById(new Long(id)));
    	return "recipe/recipeform";
    }
    
    @PostMapping
    @RequestMapping("recipe")
    public String saveOrUpdate(@ModelAttribute RecipeCommand command) {
    	RecipeCommand savedCommand = recipeService.saveRecipeCommand(command);
    	return "redirect:/recipe/"+savedCommand.getId()+"/show";
    }
    
    @GetMapping
    @RequestMapping("recipe/{id}/delete")
    public String deleteRecipe(@PathVariable String id) {
    	recipeService.deleteRecipeById(new Long(id));
    	return "redirect:/index";
    }
}