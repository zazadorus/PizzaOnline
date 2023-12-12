package fr.eni.PizzaOnline.bll;

import java.util.List;

public interface CustomerManager {
	
	public void addCustomer(Customer customer);
	
	public void modCustomer(Long id);
	
	public void delCustomer(Long id);
	
	public List<Customer> getAllCustomers();
	
	public Customer getCustomerById(Long id);
	
}
