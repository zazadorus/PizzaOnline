package fr.eni.PizzaOnline.bll;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.eni.PizzaOnline.bo.Ingredient;
import fr.eni.PizzaOnline.dal.IngredientDAO;

@Service
public class IngredientManagerImpl implements IngredientManager{

	@Autowired
	IngredientDAO ingredientDAO;
	
	@Override
	// TEST : OK
	public void addIngredient(Ingredient ingredient) {
		ingredientDAO.save(ingredient);	
	}

	@Override
	// TEST : NOK
	public void modIngredient(Ingredient ingredient) {
		ingredientDAO.save(ingredient);
		
	}

	@Override
	// TEST : OK
	public void delIngredient(Integer id) {
		Ingredient ingredient = getIngredientById(id);
		ingredientDAO.delete(ingredient);
		
	}

	@Override
	// TEST : OK
	public List<Ingredient> getAllIngredients() {
		return (List<Ingredient>) ingredientDAO.findAll();
	}

	@Override
	// TEST : OK
	public Ingredient getIngredientById(Integer id) {
		return ingredientDAO.findById(id).orElse(null);
	}


	
}
