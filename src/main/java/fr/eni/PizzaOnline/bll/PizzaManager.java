package fr.eni.PizzaOnline.bll;

import java.util.List;

import fr.eni.PizzaOnline.bo.Food;
import fr.eni.PizzaOnline.bo.Pizza;

public interface PizzaManager {

	public void addPizza(Pizza pizza);
	
	public void modPizza(Long id);
	
	public void delPizza(Long id);
	
	public List<Pizza> getAllPizzas();
	
	public Pizza getPizzaById(Long id);
	
	public Double getPizzaPrice(Pizza pizza);
	
	public List<Food> getFoodByPizza(Pizza pizza);
	
}
