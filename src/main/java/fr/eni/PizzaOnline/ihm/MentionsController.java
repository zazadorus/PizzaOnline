package fr.eni.PizzaOnline.ihm;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/mentions")
public class MentionsController {

	@GetMapping
	public String mentions(Model model) {
		return "mentions";
	}
	
}
