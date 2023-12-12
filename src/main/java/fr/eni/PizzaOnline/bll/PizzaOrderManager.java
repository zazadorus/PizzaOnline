package fr.eni.PizzaOnline.bll;

import java.util.List;

import fr.eni.PizzaOnline.bo.Cart;
import fr.eni.PizzaOnline.bo.Customer;
import fr.eni.PizzaOnline.bo.PizzaOrder;
import fr.eni.PizzaOnline.bo.ReductionCode;

public interface PizzaOrderManager {

	public void addPizzaOrder(PizzaOrder pizzaOrder);
	
	public void modPizzaOrder(Long id);
	
	public void delPizzaOrder(Long id);
	
	public List<PizzaOrder> getAllPizzaOrders();
	
	public PizzaOrder getPizzaOrderById(Long id);
	
	public Double getTotalPrice(PizzaOrder pizzaOrder);
	
	public PizzaOrder setPizzaOrder(Cart cart, Customer customer, ReductionCode reductionCode);
	
}
