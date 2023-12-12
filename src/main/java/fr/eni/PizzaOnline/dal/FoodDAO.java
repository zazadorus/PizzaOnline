package fr.eni.PizzaOnline.dal;

import org.springframework.data.repository.CrudRepository;
import fr.eni.PizzaOnline.bo.Food;

public interface FoodDAO extends CrudRepository<Food, Long>{

}
