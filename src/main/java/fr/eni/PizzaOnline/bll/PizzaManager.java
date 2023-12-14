package fr.eni.PizzaOnline.bll;

import java.util.List;

import fr.eni.PizzaOnline.bo.Food;
import fr.eni.PizzaOnline.bo.Pizza;

public interface PizzaManager {
	
	public void addPizza(Pizza pizza);
	
	public void modPizza(Pizza pizza);
	
	public void delPizza(Integer id);
	
	public List<Pizza> getAllPizzas();
	
	public Pizza getPizzaById(Integer id);
	
	public Double getPizzaPrice(Pizza pizza);
	
	public List<Food> getFoodByPizza(Pizza pizza);
	
}
