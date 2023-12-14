package fr.eni.PizzaOnline.bll;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.eni.PizzaOnline.bo.Cart;
import fr.eni.PizzaOnline.bo.Pizza;

@Service
public class CartManagerImpl implements CartManager {

	@Autowired
	PizzaManager pizzaManager;
	
	// Methode pour obtenir le prix d'un panier à partir du prix des pizzas
	// TEST : OK
	@Override
	public Double getTotalPrice(Cart cart) {
		Double price = 0.00;
		List <Pizza> listPizza = new ArrayList<>();
		listPizza = cart.getListPizza();
		for(Pizza p : listPizza) {
			price += p.getPrice();
		}
		return price;
	}
	
}
