package fr.eni.PizzaOnline.ihm;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import fr.eni.PizzaOnline.bll.BaseManager;
import fr.eni.PizzaOnline.bll.CheeseManager;
import fr.eni.PizzaOnline.bll.IngredientManager;
import fr.eni.PizzaOnline.bll.PizzaManager;
import fr.eni.PizzaOnline.bo.Pizza;
import fr.eni.PizzaOnline.dal.PizzaDAO;
import jakarta.validation.Valid;

@Controller
@RequestMapping("/ajout-pizza")
public class PizzaFormController {
	@Autowired
	CheeseManager cheeseManager;
	@Autowired
	BaseManager baseManager;
	@Autowired
	PizzaManager pizzaManager;
	@Autowired
	IngredientManager ingredientManager;
	
	@GetMapping
	public String index(Pizza pizza, Model model) {
		model.addAttribute("listeBases", baseManager.getAllBases());
		model.addAttribute("listeCheeses", cheeseManager.getAllCheeses());
		model.addAttribute("listeIngredients", ingredientManager.getAllIngredients());

		return "pizza-form";
	}
	
	@PostMapping
	public String add(@Valid Pizza pizza,  Model model, BindingResult errors) {

		System.out.println("ICI TEST AJOUT PIZZA PERSO");
		pizza.setAvailableOnSite(false);
		pizza.setAvailableTakeAway(false);
		pizza.getListCheese().forEach(System.out::println);
		pizza.setPrice(pizzaManager.getPizzaPrice(pizza));
		pizzaManager.addPizza(pizza);
		model.addAttribute("customPizza", pizza);
		return "redirect:/liste";
}
	}