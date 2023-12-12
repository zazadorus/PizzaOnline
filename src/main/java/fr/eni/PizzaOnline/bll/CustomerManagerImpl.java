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
	public void addCustomer(Customer customer) {
		customerDAO.save(customer);
		
	}

	@Override
	public void modCustomer(Customer customer) {
		customerDAO.save(customer);
	}

	@Override
	public void delCustomer(Long id) {
		Customer customer = getCustomerById(id);
		customerDAO.delete(customer);
		
	}

	@Override
	public List<Customer> getAllCustomers() {
		return (List<Customer>) customerDAO.findAll();
	}

	@Override
	public Customer getCustomerById(Long id) {
		return customerDAO.findById(id).orElse(null);
	}

}
