package fr.eni.PizzaOnline.ihm;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/conditions")
public class ConditionsController {

	@GetMapping
	public String conditions(Model model) {
		return "conditions";
	}
}
