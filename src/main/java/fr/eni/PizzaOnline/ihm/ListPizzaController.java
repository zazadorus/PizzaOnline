package fr.eni.PizzaOnline.ihm;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import fr.eni.PizzaOnline.bll.PizzaManager;

@Controller
@RequestMapping("/liste")
public class ListPizzaController {
	
	@Autowired
	PizzaManager pizzaManager;
	
	@GetMapping
	public String index( Model model) {
		model.addAttribute("listePizzas", pizzaManager.getAllPizzas());
		return "list-pizzas";
	}

}
