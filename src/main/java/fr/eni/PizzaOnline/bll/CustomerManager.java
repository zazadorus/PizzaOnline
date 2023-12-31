package fr.eni.PizzaOnline.bll;

import java.util.List;

import fr.eni.PizzaOnline.bo.Customer;

public interface CustomerManager {
	
	public void addCustomer(Customer customer);
	
	public void modCustomer(Customer customer);
	
	public void delCustomer(Integer id);
	
	public List<Customer> getAllCustomers();
	
	public Customer getCustomerById(Integer id);
	
}
