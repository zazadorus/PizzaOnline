package fr.eni.PizzaOnline.ihm;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import fr.eni.PizzaOnline.bll.CartManager;
import fr.eni.PizzaOnline.bll.CustomerManager;
import fr.eni.PizzaOnline.bll.PizzaManager;
import fr.eni.PizzaOnline.bll.PizzaOrderManager;
import fr.eni.PizzaOnline.bo.Cart;
import fr.eni.PizzaOnline.bo.Customer;
import fr.eni.PizzaOnline.bo.Pizza;
import fr.eni.PizzaOnline.bo.PizzaOrder;
import fr.eni.PizzaOnline.bo.ReductionCode;
import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/recap-commande")
public class OrderController {

	@Autowired
	PizzaManager pizzaManager;
	@Autowired
	CartManager cartManager;
	@Autowired
	PizzaOrderManager pizzaOrderManager;
	@Autowired
	CustomerManager customerManager;
	
	@PostMapping
	public String cart(HttpSession session, Model model) {
		
		Cart cart;
		PizzaOrder order;
		List<Pizza> pizzaList;
		
		System.out.println("YEAAAAAAAAAAAAAAAAAH HERE post recap commande	 ");

				
		// Si l'attribut cart n'est pas enregistré en session, le créer
		if (session.getAttribute("cart") == null) {
			return "redirect:/commande";
		} else {
			// Sinon récupérer le panier de la session et la liste de pizza ajoutée au panier
			cart = (Cart) session.getAttribute("cart");
			if (cart.getListPizza().size()>0) {
				
			pizzaList = cart.getListPizza();
			order = new PizzaOrder(LocalDate.now(), "00h00", 
					LocalDate.now(), "00h00", null, pizzaList, customerManager.getCustomerById(1));
			pizzaOrderManager.addPizzaOrder(order);
			//PizzaOrder(LocalDate deliveryDate, String deliveryHour, LocalDate orderDate, String orderHour,
			//ReductionCode reductionCode, List<Pizza> listPizza, Customer customer)
			} else {
				return "redirect:/commande";
			}
		}
		
		model.addAttribute("order", order);
		model.addAttribute("listePizzas", pizzaManager.getAllPizzas());
		model.addAttribute("totalOrder", pizzaOrderManager.getTotalPrice(order));
		
		return "confirmation-order";
		
	}
	
//	@PostMapping
//	public String convertCartToOrder(HttpSession session, Model model) {
////		if(errors.hasErrors()) {
////			System.out.println("ERRRRRREUR");
////			return "personne";
////		}
////		pizzaOrderManager.addContactMessage(contactMessage);
////		session.setAttribute("contactMessage", contactMessage);
//		System.out.println("YEAAAAAAAAAAAAAAAAAH HERE POST");
//		Cart cart;
//		List<Pizza> pizzaList;
//				
//		// Si l'attribut cart n'est pas enregistré en session, le créer
//		if (session.getAttribute("cart") == null) {
//			cart = new Cart();
//			pizzaList = new ArrayList<Pizza>();
//			session.setAttribute("cart", cart);
//		} else {
//			// Sinon récupérer le panier de la session et la liste de pizza ajoutée au panier
//			cart = (Cart) session.getAttribute("cart");
//			pizzaList = cart.getListPizza() != null ? cart.getListPizza() : new ArrayList<Pizza>();
//		}
//		
//		model.addAttribute("cart", cart);
//		model.addAttribute("listePizzas", pizzaManager.getAllPizzas());
//		model.addAttribute("totalCart", cartManager.getTotalPrice(cart));
//		
//		return "redirect:/recap-commande";
//	}
}
