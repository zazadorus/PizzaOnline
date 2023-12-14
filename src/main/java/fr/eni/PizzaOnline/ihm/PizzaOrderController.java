package fr.eni.PizzaOnline.ihm;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import fr.eni.PizzaOnline.bll.CartManager;
import fr.eni.PizzaOnline.bll.PizzaManager;
import fr.eni.PizzaOnline.bo.Cart;
import fr.eni.PizzaOnline.bo.Pizza;
import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/commande")
public class PizzaOrderController {
	
	@Autowired
	PizzaManager pizzaManager;
	@Autowired
	CartManager cartManager;
	
	@GetMapping
	public String index(Model model, HttpSession session) {
		
		// Si l'attribut cart n'est pas enregistré en session, le créer
		if (session.getAttribute("cart") == null) {	
			Cart cart = new Cart();
			session.setAttribute("cart", cart);
		}
		
		model.addAttribute("cart",session.getAttribute("cart"));
		model.addAttribute("listePizzas", pizzaManager.getAllPizzas());
		
		return "pizza-order";
	}
	
	@PostMapping
	public String add(@RequestParam(name = "pizzaId") String pizzaId, @RequestParam(name = "quantity") String quantity, HttpSession session, Model model) {
		
		Cart cart;
		List<Pizza> pizzaList;
		
		// Récupération de la pizza via id(pizzaId) dont on souhaite ajouter une quantité (quantity)
		Pizza pizza = pizzaManager.getPizzaById(Integer.parseInt(pizzaId));
		
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
		
		// Ajouter la pizza le nombre de fois = à quantity
		for (int i = 0; i<Integer.parseInt(quantity);i++) {			
			pizzaList.add(pizza);
		}
		


		cart.setListPizza(pizzaList);
		model.addAttribute("cart", cart);
		model.addAttribute("listePizzas", pizzaManager.getAllPizzas());
		model.addAttribute("totalCart", cartManager.getTotalPrice(cart));
		return "pizza-order";
	}


}
