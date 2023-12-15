package fr.eni.PizzaOnline.ihm;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/restaurant")
public class RestaurantController {

	
	@GetMapping
	public String restaurant(Model model) {
		return "restaurant";
	}
		
}
