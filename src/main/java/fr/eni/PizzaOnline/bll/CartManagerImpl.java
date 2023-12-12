package fr.eni.PizzaOnline.bll;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class CartManagerImpl implements CartManager {

	// Methode pour obtenir le prix d'un panier à partir du prix des pizzas
	@Override
	public Double getTotalPrice(Cart cart) {
		Double price = 0.00;
		List <Pizza> listPizza = new ArrayList<>();
		listPizza = cart.getListPizza();
		for(Pizza p : listPizza) {
			price += p.getPizzaPrice();
		}
		return price;
	}
	
}
