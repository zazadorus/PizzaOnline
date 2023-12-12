package fr.eni.PizzaOnline.bll;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.eni.PizzaOnline.bo.Cheese;
import fr.eni.PizzaOnline.bo.Food;
import fr.eni.PizzaOnline.bo.Ingredient;
import fr.eni.PizzaOnline.bo.Pizza;
import fr.eni.PizzaOnline.dal.PizzaDAO;

@Service
public class PizzaManagerImpl implements PizzaManager {

	@Autowired
	PizzaDAO pizzaDAO;

	@Override
	public void addPizza(Pizza pizza) {
		pizzaDAO.save(pizza);
		
	}	
	@Override
	public void modPizza(Pizza pizza) {
		pizzaDAO.save(pizza);
		
	}

	@Override
	public void delPizza(Long id) {
		Pizza pizza = getPizzaById(id);
		pizzaDAO.delete(pizza);
	}

	@Override
	public List<Pizza> getAllPizzas() {
		return (List<Pizza>) pizzaDAO.findAll();
	}

	@Override
	public Pizza getPizzaById(Long id) {
		return pizzaDAO.findById(id).orElse(null);
	}
	
	// Méthode pour lister les ingrédients d'une pizza
	@Override
	public List<Food> getFoodByPizza(Pizza pizza) {
		List <Food> listFood = new ArrayList<>();
		
		for(Cheese c : pizza.getListCheese()) {
			listFood.add(c);
		}
		
		for(Ingredient i : pizza.getListIngredient()) {
			listFood.add(i);
		}
		
		listFood.add(pizza.getBase());
		
		return listFood;
	}
	
	// Méthode pour obtenir le prix d'une pizza à partir de sa liste d'ingrédients
	// Uniquement pour les pizzas créées par l'utilisateur, pour les pizzas de base du menu, utiliser getPrice()
	@Override
	public Double getPizzaPrice(Pizza pizza) {
		Double price = 0.00;
		List <Food> listFood = new ArrayList<>();
		listFood = getFoodByPizza(pizza);
		
		for(Food f : listFood) {
			price += f.getPrice();
		}
		return price;
	}
	
}
