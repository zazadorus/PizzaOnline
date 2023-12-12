package fr.eni.PizzaOnline.bll;

import java.util.List;

public interface PizzaOrderManager {

	public void addPizzaOrder(PizzaOrder pizzaOrder);
	
	public void modPizzaOrder(Long id);
	
	public void delPizzaOrder(Long id);
	
	public List<PizzaOrder> getAllPizzaOrders();
	
	public PizzaOrder getPizzaOrderById(Long id);
	
	public Double getTotalPrice(PizzaOrder pizzaOrder);
	
	public PizzaOrder setPizzaOrder(Cart cart, Customer customer, ReductionCode reductionCode);
	
	public Double getTotalPrice(PizzaOrder pizzaOrder);
	
}
