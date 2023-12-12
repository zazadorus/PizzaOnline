package fr.eni.PizzaOnline.dal;

import org.springframework.data.repository.CrudRepository;
import fr.eni.PizzaOnline.bo.Pizza;

public interface PizzaDAO extends CrudRepository<Pizza, Long>{

}
