package fr.eni.PizzaOnline.bll;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.eni.PizzaOnline.dal.PizzaOrderDAO;

@Service
public class PizzaOrderManagerImpl implements PizzaOrderManager {

	@Autowired
	PizzaOrderDAO pizzaOrderDAO;
	
	@Override
	public void addPizzaOrder(PizzaOrder pizzaOrder) {
		pizzaOrderDAO.save(pizzaOrder);
		
	}

	@Override
	public void modPizzaOrder(Long id) {
		PizzaOrder pizzaOrder = pizzaOrderDAO.findById(id);
		pizzaOrderDAO.save(pizzaOrder);
		
	}

	@Override
	public void delPizzaOrder(Long id) {
		PizzaOrder pizzaOrder = pizzaOrderDAO.findById(id);
		pizzaOrderDAO.delete(pizzaOrder);
		
	}

	@Override
	public List<PizzaOrder> getAllPizzaOrders() {
		return pizzaOrderDAO.findAll();
	}

	@Override
	public PizzaOrder getPizzaOrderById(Long id) {
		return pizzaOrderDAO.findById(id).OrElse(null);
	}
	
	// Méthode pour construire une commande à partir d'un panier, d'un client, et d'un code de réduction
	@Override
	public PizzaOrder setPizzaOrder(Cart cart, Customer customer, ReductionCode reductionCode) {
		List<Food> listPizza = new ArrayList<>();
		listPizza = cart.getListPizza();
		
		return new PizzaOrder(LocalDate.now(), "10h00", localDat.now(), "11h00", listPizza, customer, reductionCode);
	}
	
	// M&thode pour obtenir le prix d'une commande à partir des pizzas et du code de réduction
	@Override
	public Double getTotalPrice(PizzaOrder pizzaOrder) {
		Double price = 0.00;
		List <Pizza> listPizza = new ArrayList<>();
		listPizza = pizzaOrder.getListPizza();
		for(Pizza p : listPizza) {
			price += p.getPizzaPrice();
		}
		price = price * (1-pizzaOrder.getReductionCode().getReduction()/100);
		return price;
	}
	
}
