package fr.eni.PizzaOnline.ihm;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import fr.eni.PizzaOnline.bll.ContactMessageManager;
import fr.eni.PizzaOnline.bo.ContactMessage;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
@RequestMapping("/contact")
public class ContactController {

	@Autowired
	ContactMessageManager contactMessageManager;
	
	@GetMapping
	public String contact(ContactMessage contactMessage, Model model) {
		return "contact";
	}
	
	@PostMapping
	public String addMessage(HttpSession session, @Valid ContactMessage contactMessage, Model model, BindingResult errors) {
		if(errors.hasErrors()) {
			System.out.println("ERRRRRREUR");
			return "personne";
		}
		contactMessageManager.addContactMessage(contactMessage);
		session.setAttribute("contactMessage", contactMessage);
		return "redirect:/message-confirmation";
	}
	
}
