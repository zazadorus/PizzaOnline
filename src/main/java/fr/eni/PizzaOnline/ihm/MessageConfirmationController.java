package fr.eni.PizzaOnline.ihm;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import fr.eni.PizzaOnline.bll.ContactMessageManager;
import fr.eni.PizzaOnline.bo.ContactMessage;
import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/message-confirmation")
public class MessageConfirmationController {
	
	@Autowired
	ContactMessageManager contactMessageManager;
	
	@GetMapping
	public String get(HttpSession session, Model model) {
		ContactMessage contactMessage = (ContactMessage) session.getAttribute("contactMessage");
		model.addAttribute("contactMessage", contactMessage);
		return "message-confirmation";
	}

}
