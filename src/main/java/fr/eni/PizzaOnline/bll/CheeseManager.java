package fr.eni.PizzaOnline.bll;

import java.util.List;

import fr.eni.PizzaOnline.bo.Cheese;

public interface CheeseManager {

	public void addCheese(Cheese cheese);
	
	public void modCheese(Cheese cheese);
	
	public void delCheese(Integer id);
	
	public List<Cheese> getAllCheeses();
	
	public Cheese getCheeseById(Integer id);
	
}
