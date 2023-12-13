package fr.eni.PizzaOnline.bll;

import java.util.List;

import fr.eni.PizzaOnline.bo.Ingredient;

public interface IngredientManager {
	
	public void addIngredient(Ingredient ingredient);
	
	public void modIngredient(Ingredient ingredient);
	
	public void delIngredient(Integer id);
	
	public List<Ingredient> getAllIngredients();
	
	public Ingredient getIngredientById(Integer id);

}
