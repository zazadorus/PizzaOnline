package fr.eni.PizzaOnline.bll;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.eni.PizzaOnline.bo.Cart;
import fr.eni.PizzaOnline.bo.Customer;
import fr.eni.PizzaOnline.bo.Food;
import fr.eni.PizzaOnline.bo.Pizza;
import fr.eni.PizzaOnline.bo.PizzaOrder;
import fr.eni.PizzaOnline.bo.ReductionCode;
import fr.eni.PizzaOnline.dal.PizzaOrderDAO;

@Service
public class PizzaOrderManagerImpl implements PizzaOrderManager {

	@Autowired
	PizzaOrderDAO pizzaOrderDAO;
	
	@Autowired
	PizzaManager pizzaManager;
	
	@Override
	public void addPizzaOrder(PizzaOrder pizzaOrder) {
		pizzaOrderDAO.save(pizzaOrder);
		
	}

	@Override
	public void modPizzaOrder(Long id) {
		PizzaOrder pizzaOrder = getPizzaOrderById(id);
		pizzaOrderDAO.save(pizzaOrder);
		
	}

	@Override
	public void delPizzaOrder(Long id) {
		PizzaOrder pizzaOrder = getPizzaOrderById(id);
		pizzaOrderDAO.delete(pizzaOrder);
		
	}

	@Override
	public List<PizzaOrder> getAllPizzaOrders() {
		return (List<PizzaOrder>) pizzaOrderDAO.findAll();
	}

	@Override
	public PizzaOrder getPizzaOrderById(Long id) {
		return pizzaOrderDAO.findById(id).orElse(null);
	}
	
	// Méthode pour construire une commande à partir d'un panier, d'un client, et d'un code de réduction
	@Override
	public PizzaOrder setPizzaOrder(Cart cart, Customer customer, ReductionCode reductionCode) {
		List<Food> listPizza = new ArrayList<>();
		listPizza = cart.getListPizza();
		
		return new PizzaOrder(LocalDate.now(), "10h00", localDate.now(), "11h00", listPizza, customer, reductionCode);
	}
	
	// M&thode pour obtenir le prix d'une commande à partir des pizzas et du code de réduction
	@Override
	public Double getTotalPrice(PizzaOrder pizzaOrder) {
		Double price = 0.00;
		List <Pizza> listPizza = new ArrayList<>();
		listPizza = pizzaOrder.getListPizza();
		for(Pizza p : listPizza) {
			price += pizzaManager.getPizzaPrice(p);
		}
		price = price * (1-pizzaOrder.getReductionCode().getAmountReduction()/100);
		return price;
	}
	
}
