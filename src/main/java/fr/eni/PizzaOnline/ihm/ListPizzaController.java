package fr.eni.PizzaOnline.ihm;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import fr.eni.PizzaOnline.bll.PizzaManager;
import jakarta.validation.Valid;

@Controller
@RequestMapping("/ListePizza")
public class ListPizzaController {
	
	PizzaManager pizzaManager;
	
	@GetMapping
	public String index( Model model) {
		model.addAttribute("listePizzas", pizzaManager.getAllPizzas());
		return "list-pizzas";
	}

}
