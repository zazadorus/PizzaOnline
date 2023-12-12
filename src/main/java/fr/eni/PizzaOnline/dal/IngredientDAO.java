package fr.eni.PizzaOnline.dal;

import org.springframework.data.repository.CrudRepository;
import fr.eni.PizzaOnline.bo.Ingredient;

public interface IngredientDAO extends CrudRepository<Ingredient, Long>{

}
