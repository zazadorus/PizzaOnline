//package fr.eni.PizzaOnline.ihm;
//
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.DeleteMapping;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.PutMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//
//import fr.eni.PizzaOnline.bll.BaseManager;
//import fr.eni.PizzaOnline.bll.CheeseManager;
//import fr.eni.PizzaOnline.bll.IngredientManager;
//import fr.eni.PizzaOnline.bll.PizzaManager;
//import fr.eni.PizzaOnline.bo.Base;
//import fr.eni.PizzaOnline.bo.Cheese;
//import fr.eni.PizzaOnline.bo.Ingredient;
//import fr.eni.PizzaOnline.bo.Pizza;
//import jakarta.validation.Valid;
//
//@Controller
//@RequestMapping("/pizza")
//public class PizzaController {
//	@Autowired
//	CheeseManager cheeseManager;
//	@Autowired
//	BaseManager baseManager;
//	@Autowired
//	PizzaManager pizzaManager;
//	@Autowired
//	IngredientManager ingredientManager;
//	
//	@GetMapping("/{pizza_id}")
//	public String details(@RequestParam int pizzaId) {
//		return "pizza-details";
//	}
//	
//	@GetMapping
//	public String list(Model model) {
//		List<Pizza> pizzas = pizzaManager.getAllPizzas();
//		model.addAttribute("pizzas", pizzas);
//		return "pizza-list";
//	}
//	
//	@PostMapping("/add")
//	public String index(@Valid Pizza pizza, Model model) {
//		
//		if (pizza.isValid() && pizza.isSubmit()) {
//			pizzaManager.addPizza(pizza);
//		}
//		
//		List<Base> listBases = baseManager.getAllBases();
//		List<Cheese> listCheeses = cheeseManager.getAllCheeses();
//		List<Ingredient> listIngredients = ingredientManager.getAllIngredients();
//		
// 		model.addAttribute("listeBases", listBases);
//		model.addAttribute("listeCheeses", listCheeses);
//		model.addAttribute("listeIngredients", listIngredients);
//		
//		return "pizza-add";
//		// "pizza-update" 
//	}
//	
//	@PutMapping("/update")
//	public String update(@Valid Pizza pizza, Model model) {
//		
//	}
//	
//	@DeleteMapping("/delete")
//	
//	
//	
//}
