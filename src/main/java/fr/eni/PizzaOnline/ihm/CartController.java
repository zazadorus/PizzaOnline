package fr.eni.PizzaOnline.ihm;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import fr.eni.PizzaOnline.bll.CartManager;
import fr.eni.PizzaOnline.bll.PizzaManager;
import fr.eni.PizzaOnline.bll.PizzaOrderManager;
import fr.eni.PizzaOnline.bo.Cart;
import fr.eni.PizzaOnline.bo.Pizza;
import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/panier")
public class CartController {

	@Autowired
	PizzaManager pizzaManager;
	@Autowired
	CartManager cartManager;
	@Autowired
	PizzaOrderManager pizzaOrderManager;
	
	@GetMapping
	public String cart(HttpSession session, Model model) {
		
		Cart cart;
		List<Pizza> pizzaList;
		
		System.out.println("YEAAAAAAAAAAAAAAAAAH HERE GET	 ");

				
		// Si l'attribut cart n'est pas enregistré en session, le créer
		if (session.getAttribute("cart") == null) {
			cart = new Cart();
			pizzaList = new ArrayList<Pizza>();
			session.setAttribute("cart", cart);
		} else {
			// Sinon récupérer le panier de la session et la liste de pizza ajoutée au panier
			cart = (Cart) session.getAttribute("cart");
			pizzaList = cart.getListPizza() != null ? cart.getListPizza() : new ArrayList<Pizza>();
		}
		
		model.addAttribute("cart", cart);
		model.addAttribute("listePizzas", pizzaManager.getAllPizzas());
		model.addAttribute("totalCart", cartManager.getTotalPrice(cart));
		
		return "cart";
		
	}
	
	@PostMapping
	public String convertCartToOrder(HttpSession session, Model model) {
//		if(errors.hasErrors()) {
//			System.out.println("ERRRRRREUR");
//			return "personne";
//		}
//		pizzaOrderManager.addContactMessage(contactMessage);
//		session.setAttribute("contactMessage", contactMessage);
		System.out.println("YEAAAAAAAAAAAAAAAAAH HERE POST");
		Cart cart;
		List<Pizza> pizzaList;
				
		// Si l'attribut cart n'est pas enregistré en session, le créer
		if (session.getAttribute("cart") == null) {
			cart = new Cart();
			pizzaList = new ArrayList<Pizza>();
			session.setAttribute("cart", cart);
		} else {
			// Sinon récupérer le panier de la session et la liste de pizza ajoutée au panier
			cart = (Cart) session.getAttribute("cart");
			pizzaList = cart.getListPizza() != null ? cart.getListPizza() : new ArrayList<Pizza>();
		}
		model.addAttribute("cart", cart);
		model.addAttribute("listePizzas", pizzaManager.getAllPizzas());
		model.addAttribute("totalCart", cartManager.getTotalPrice(cart));
		
		return "redirect:/panier";
	}
}
