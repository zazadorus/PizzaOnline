package fr.eni.PizzaOnline.bll;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.eni.PizzaOnline.bo.Cart;
import fr.eni.PizzaOnline.bo.Customer;
import fr.eni.PizzaOnline.bo.Pizza;
import fr.eni.PizzaOnline.bo.PizzaOrder;
import fr.eni.PizzaOnline.bo.ReductionCode;
import fr.eni.PizzaOnline.dal.PizzaOrderDAO;
import fr.eni.PizzaOnline.dal.ReductionCodeDAO;

@Service
public class PizzaOrderManagerImpl implements PizzaOrderManager {

	@Autowired
	PizzaOrderDAO pizzaOrderDAO;
	
	@Autowired
	PizzaManager pizzaManager;
	
	@Autowired
	ReductionCodeManager reductionCodeManager;
	
	@Override
	// TEST : OK
	public void addPizzaOrder(PizzaOrder pizzaOrder) {
		pizzaOrderDAO.save(pizzaOrder);
	}

	@Override
	// TEST : OK
	public void modPizzaOrder(PizzaOrder pizzaOrder) {
		pizzaOrderDAO.save(pizzaOrder);
		
	}

	@Override
	// TEST : OK
	public void delPizzaOrder(Integer id) {
		PizzaOrder pizzaOrder = getPizzaOrderById(id);
		pizzaOrderDAO.delete(pizzaOrder);
		
	}

	@Override
	// TEST : OK
	public List<PizzaOrder> getAllPizzaOrders() {
		return (List<PizzaOrder>) pizzaOrderDAO.findAll();
	}

	@Override
	// TEST : NOK
	public PizzaOrder getPizzaOrderById(Integer id) {
		return pizzaOrderDAO.findById(id).orElse(null);
	}
	
	// Méthode pour construire une commande à partir d'un panier, d'un client, et d'un code de réduction
	@Override
	// TEST : OK
	// A modifier pour les dates livraison et commande
	public PizzaOrder setPizzaOrder(Cart cart, Customer customer, String code) {
		List<Pizza> listPizza = new ArrayList<>();
		listPizza = cart.getListPizza();
		ReductionCode reductionCode = null;
		if(code != null) {
			reductionCode = reductionCodeManager.getAmountReductionByCode(code);
		}
		
		return new PizzaOrder(LocalDate.now(), "10h00", LocalDate.now(), "11h00",reductionCode, listPizza, customer);
	}
	
	// Méthode pour obtenir le prix d'une commande à partir des pizzas et du code de réduction
	@Override
	// TEST : OK
	public Double getTotalPrice(PizzaOrder pizzaOrder) {
		Double price = 0.00;
		List <Pizza> listPizza = new ArrayList<>();
		listPizza = pizzaOrder.getListPizza();
		for(Pizza p : listPizza) {
			price += p.getPrice();
		}
		if(pizzaOrder.getReductionCode()!=null) {
			price = price * (1-pizzaOrder.getReductionCode().getAmountReduction());
		}
		return price;
	}
	
}
