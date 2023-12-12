package fr.eni.PizzaOnline.dal;

import org.springframework.data.repository.CrudRepository;

import fr.eni.PizzaOnline.bo.Cheese;

public interface CheeseDAO extends CrudRepository<Cheese, Long>{

}
