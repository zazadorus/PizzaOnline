package fr.eni.PizzaOnline.bll;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
	public void modCustomer(Long id) {
		Customer customer = customerDAO.findById(id);
		customerDAO.save(customer);
	}

	@Override
	public void delCustomer(Long id) {
		Customer customer = customerDAO.findById(id);
		customerDAO.delete(customer);
		
	}

	@Override
	public List<Customer> getAllCustomers() {
		return customerDAO.findAll();
	}

	@Override
	public Customer getCustomerById(Long id) {
		return customerDAO.findById(id).OrElse(null);
	}

}
