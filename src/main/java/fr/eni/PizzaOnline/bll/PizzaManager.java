package fr.eni.PizzaOnline.bll;

import java.util.List;

import fr.eni.PizzaOnline.bo.Base;
import fr.eni.PizzaOnline.bo.Cheese;
import fr.eni.PizzaOnline.bo.Food;
import fr.eni.PizzaOnline.bo.Ingredient;
import fr.eni.PizzaOnline.bo.Pizza;

public interface PizzaManager {

	// Aliments
	
	public void addIngredient(Ingredient ingredient);

	public void addCheese(Cheese cheese);
	
	public void addBase(Base base);
	
	// Pizzas
	
	public void addPizza(Pizza pizza);
	
	public void modPizza(Pizza pizza);
	
	public void delPizza(Long id);
	
	public List<Pizza> getAllPizzas();
	
	public Pizza getPizzaById(Long id);
	
	public Double getPizzaPrice(Pizza pizza);
	
	public List<Food> getFoodByPizza(Pizza pizza);
	
}
