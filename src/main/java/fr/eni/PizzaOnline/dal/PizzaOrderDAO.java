package fr.eni.PizzaOnline.dal;

import org.springframework.data.repository.CrudRepository;
import fr.eni.PizzaOnline.bo.PizzaOrder;

public interface PizzaOrderDAO extends CrudRepository<PizzaOrder, Long>{

}

