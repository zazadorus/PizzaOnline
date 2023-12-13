package fr.eni.PizzaOnline.dal;

import org.springframework.data.repository.CrudRepository;
import fr.eni.PizzaOnline.bo.Base;

public interface BaseDAO extends CrudRepository<Base, Integer>{

}
