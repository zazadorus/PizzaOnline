package fr.eni.PizzaOnline.bll;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.eni.PizzaOnline.bo.Cheese;
import fr.eni.PizzaOnline.dal.CheeseDAO;

@Service
public class CheeseManagerImpl implements CheeseManager{

	@Autowired
	CheeseDAO cheeseDAO;
	
	@Override
	@Transactional
	// TEST : OK
	public void addCheese(Cheese cheese) {
		cheeseDAO.save(cheese);
	}

	@Override
	@Transactional
	// TEST : OK
	public void modCheese(Cheese cheese) {
		cheeseDAO.save(cheese);
	}

	@Override
	@Transactional
	// TEST : OK
	public void delCheese(Integer id) {
		Cheese cheese = getCheeseById(id);
		cheeseDAO.delete(cheese);
		
	}

	@Override
	// TEST : OK
	public List<Cheese> getAllCheeses() {
		return (List<Cheese>) cheeseDAO.findAll();
	}

	@Override
	// TEST : OK
	public Cheese getCheeseById(Integer id) {
		return cheeseDAO.findById(id).orElse(null);
	}

}
