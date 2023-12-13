package fr.eni.PizzaOnline.bll;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.eni.PizzaOnline.bo.Customer;
import fr.eni.PizzaOnline.dal.CustomerDAO;

@Service
public class CustomerManagerImpl implements CustomerManager{

	@Autowired
	CustomerDAO customerDAO;
	
	@Override
	// TEST : OK
	public void addCustomer(Customer customer) {
		customerDAO.save(customer);
		
	}

	@Override
	// TEST : NOK
	public void modCustomer(Customer customer) {
		customerDAO.save(customer);
	}

	@Override
	// TEST : OK pour customer sans commande
	// test à réaliser avec commande
	public void delCustomer(Integer id) {
		Customer customer = getCustomerById(id);
		customerDAO.delete(customer);
		
	}

	@Override
	// TEST : NOK
	// failed to lazily initialize a collection of role: fr.eni.PizzaOnline.bo.Customer.pizzaOrder: could not initialize proxy - no Session
	public List<Customer> getAllCustomers() {
		return (List<Customer>) customerDAO.findAll();
	}

	@Override
	// TEST : NOK
	// failed to lazily initialize a collection of role: fr.eni.PizzaOnline.bo.Customer.pizzaOrder: could not initialize proxy - no Session
	public Customer getCustomerById(Integer id) {
		return customerDAO.findById(id).orElse(null);
	}

}
