package fr.eni.PizzaOnline.dal;

import org.springframework.data.repository.CrudRepository;
import fr.eni.PizzaOnline.bo.Customer;

public interface CustomerDAO extends CrudRepository<Customer, Integer>{

}
