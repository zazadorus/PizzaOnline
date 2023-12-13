package fr.eni.PizzaOnline.bll;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.eni.PizzaOnline.bo.Base;
import fr.eni.PizzaOnline.bo.Cheese;
import fr.eni.PizzaOnline.bo.Food;
import fr.eni.PizzaOnline.bo.Ingredient;
import fr.eni.PizzaOnline.bo.Pizza;
import fr.eni.PizzaOnline.dal.BaseDAO;
import fr.eni.PizzaOnline.dal.CheeseDAO;
import fr.eni.PizzaOnline.dal.IngredientDAO;
import fr.eni.PizzaOnline.dal.PizzaDAO;

@Service
public class PizzaManagerImpl implements PizzaManager {

	@Autowired
	PizzaDAO pizzaDAO;
	@Autowired
	CheeseDAO cheeseDAO;
	@Autowired
	BaseDAO baseDAO;
	@Autowired
	IngredientDAO ingredientDAO;

	@Override
	// TEST : OK
	public void addPizza(Pizza pizza) {
		pizzaDAO.save(pizza);
	}
		
	@Override
	// TEST : NOK
	public void modPizza(Pizza pizza) {
		pizzaDAO.save(pizza);
	}

	@Override
	// TEST : NOK
	// Intégrité référentielle violation de contrainte: "FKNLOW8KD7GSHS3I14XQNA7ESAI: PUBLIC.PIZZA_ORDER_LIST_PIZZA FOREIGN KEY(LIST_PIZZA_ID) REFERENCES PUBLIC.PIZZA(ID) (2)"
	// Referential integrity constraint violation: "FKNLOW8KD7GSHS3I14XQNA7ESAI: PUBLIC.PIZZA_ORDER_LIST_PIZZA FOREIGN KEY(LIST_PIZZA_ID) REFERENCES PUBLIC.PIZZA(ID) (2)"; SQL statement:
	public void delPizza(Integer id) {
		Pizza pizza = getPizzaById(id);
		pizzaDAO.delete(pizza);
	}

	@Override
	// TEST : OK
	public List<Pizza> getAllPizzas() {
		return (List<Pizza>) pizzaDAO.findAll();
	}

	@Override
	// TEST : OK
	public Pizza getPizzaById(Integer id) {
		return pizzaDAO.findById(id).orElse(null);
	}
	
	// Méthode pour lister les ingrédients d'une pizza
	@Override
	// TEST : OK
	public List<Food> getFoodByPizza(Pizza pizza) {
		List<Food> listFood = new ArrayList<>();
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
	// Uniquement pour les pizzas créées par l'utilisateur
	@Override
	// TEST : OK
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
