package fr.eni.PizzaOnline;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import fr.eni.PizzaOnline.bll.BaseManager;
import fr.eni.PizzaOnline.bll.CartManager;
import fr.eni.PizzaOnline.bll.CheeseManager;
import fr.eni.PizzaOnline.bll.CustomerManager;
import fr.eni.PizzaOnline.bll.IngredientManager;
import fr.eni.PizzaOnline.bll.PizzaManager;
import fr.eni.PizzaOnline.bll.PizzaOrderManager;
import fr.eni.PizzaOnline.bll.ReductionCodeManager;
import fr.eni.PizzaOnline.bo.Base;
import fr.eni.PizzaOnline.bo.Cart;
import fr.eni.PizzaOnline.bo.Cheese;
import fr.eni.PizzaOnline.bo.Customer;
import fr.eni.PizzaOnline.bo.Ingredient;
import fr.eni.PizzaOnline.bo.Pizza;
import fr.eni.PizzaOnline.bo.PizzaOrder;
import fr.eni.PizzaOnline.bo.ReductionCode;
import jakarta.annotation.PostConstruct;

@SpringBootApplication
public class PizzaOnlineMvcApplication {

	@Autowired
	BaseManager baseManager;
	
	@Autowired
	IngredientManager ingredientManager;
	
	@Autowired
	CheeseManager cheeseManager;
	
	@Autowired
	PizzaManager pizzaManager;
	   
	@Autowired
	CartManager cartManager;

	@Autowired
	CustomerManager customerManager;
	
	@Autowired
	ReductionCodeManager reductionCodeManager;
	   
	@Autowired
	PizzaOrderManager pizzaOrderManager;
	   
	@PostConstruct
	public void init() {
		initializeFood();
	}
	    
	public static void main(String[] args) {
		SpringApplication.run(PizzaOnlineApplication.class, args);
	}
	  
	private void initializeFood() {
	        
		// CHEESE
		System.out.println("CHEESE");
		//1. Création
	    Double cheesePrice = 1.0;
	    Cheese brie = new Cheese ("Brie de Meaux", cheesePrice);
	    Cheese mozzarella = new Cheese ("Mozzarella", cheesePrice);
	    Cheese goatCheese = new Cheese ("chèvre", cheesePrice);
	    Cheese emmental = new Cheese ("emmental", cheesePrice);
	    Cheese gorgonzola = new Cheese ("Gorgonzola AOP", cheesePrice);
	    //2. Test add + getAll
	    cheeseManager.addCheese(brie);
	    cheeseManager.addCheese(mozzarella);
	    cheeseManager.addCheese(goatCheese);
	    cheeseManager.addCheese(emmental);
	    cheeseManager.addCheese(gorgonzola);
	    System.out.println("Test addCheese + getAllCheeses : ");
	    cheeseManager.getAllCheeses().forEach(System.out::println);
	    //3. Test mod
	    Cheese cheeseDelTest = new Cheese ("CheeseDelTest", cheesePrice);
	    cheeseManager.modCheese(cheeseDelTest);
	    System.out.println("Test modCheese : ");
	    cheeseManager.getAllCheeses().forEach(System.out::println);
	    //4. Test del
	    cheeseManager.delCheese(6);
	    System.out.println("Test delCheese : ");
	    cheeseManager.getAllCheeses().forEach(System.out::println);
	    //5. Test getCheeseById
	    System.out.println("Test getCheeseById : ");
	    System.out.println(cheeseManager.getCheeseById(1));
	    System.out.println();
	    
	    // INGREDIENT
	    System.out.println("INGREDIENT");
	    //1. Création
	    Double ingredientPrice = 1.0;
		Ingredient bacon = new Ingredient ("Bacon", ingredientPrice);
		Ingredient pineapple = new Ingredient ("Ananas", ingredientPrice);
		Ingredient kebab = new Ingredient ("Viande de Kebab", ingredientPrice);
		Ingredient olives = new Ingredient ("Olives Kalamata", ingredientPrice);
		Ingredient salmon = new Ingredient ("Saumon fumé", ingredientPrice);
		Ingredient prune = new Ingredient ("Pruneau d'Agean", ingredientPrice);
		Ingredient coypu = new Ingredient ("Ragondin", ingredientPrice);
		//2. Test add + getAll
		ingredientManager.addIngredient(bacon);
		ingredientManager.addIngredient(pineapple);
		ingredientManager.addIngredient(kebab);
		ingredientManager.addIngredient(olives);
		ingredientManager.addIngredient(salmon);
		ingredientManager.addIngredient(prune);
		ingredientManager.addIngredient(coypu);
		System.out.println("Test addIngredient + getAllIngredient : ");
		ingredientManager.getAllIngredients().forEach(System.out::println);
		//3. Test mod
	    Ingredient ingredientDelTest = new Ingredient ("IngredientDelTest", cheesePrice);
		ingredientManager.modIngredient(ingredientDelTest);
	    System.out.println("Test modIngredient : ");
	    ingredientManager.getAllIngredients().forEach(System.out::println);
	    //4. Test del
		ingredientManager.delIngredient(14);
	    System.out.println("Test modIngredient : ");
	    ingredientManager.getAllIngredients().forEach(System.out::println);
	    //5. Test getIngredientById
	    System.out.println("Test getIngredientById : ");
	    System.out.println(ingredientManager.getIngredientById(13));
	    System.out.println();
	    
	    // BASE
	    System.out.println("BASE");
	    //1. Création
		Base tomato = new Base ("Base tomate",5.0);
		Base cream = new Base ("Base crème",6.0);
		//2. Test add + getAll
		baseManager.addBase(tomato);
		baseManager.addBase(cream);
		System.out.println("Test addbase + getAllBases : ");
		baseManager.getAllBases().forEach(System.out::println);
		//3. Test mod
		Base baseDelTest = new Base ("BaseDelTest", 4.0);
		baseManager.modBase(baseDelTest);
	    System.out.println("Test modbase : ");
	    baseManager.getAllBases().forEach(System.out::println);
	    //4. Test del
		baseManager.delBase(17);
	    System.out.println("Test delBase : ");
	    baseManager.getAllBases().forEach(System.out::println);
	    //5. Test getbaseById
	    System.out.println("Test getBaseById : ");
	    System.out.println(baseManager.getBaseById(16));
	    System.out.println();
	    
		// Création des listes
		List <Cheese> pizza1Cheese= new ArrayList<>();
		pizza1Cheese.add(brie);
		pizza1Cheese.add(goatCheese);
		List <Ingredient> pizza1Ingredient= new ArrayList<>();
		pizza1Ingredient.add(bacon);
		pizza1Ingredient.add(olives);       
		List <Cheese> pizza2Cheese= new ArrayList<>();
		pizza2Cheese.add(gorgonzola);
		pizza2Cheese.add(mozzarella);    	
		List <Ingredient> pizza2Ingredient= new ArrayList<>();
		pizza2Ingredient.add(salmon);
		pizza2Ingredient.add(prune);    	
		List <Cheese> pizza3Cheese= new ArrayList<>();
		pizza3Cheese.add(emmental);
		pizza3Cheese.add(gorgonzola);
		pizza3Cheese.add(goatCheese);	    	
		List <Ingredient> pizza3Ingredient= new ArrayList<>();
		pizza3Ingredient.add(pineapple);
		pizza3Ingredient.add(kebab);
		pizza3Ingredient.add(coypu);
		pizza3Ingredient.add(salmon);
		pizza3Ingredient.add(prune);
		
		// PIZZA
	    System.out.println("PIZZA");
		//1. Création
		Pizza pizza1 = new Pizza("Festin des grands jours", true,true,15.0,tomato,pizza1Cheese,pizza1Ingredient);
		Pizza pizza2 = new Pizza("Grana Delicioza", true,true,13.50,tomato,pizza2Cheese,pizza2Ingredient);
		Pizza pizza3 = new Pizza("Opération gastro", true,true,5.0,cream,pizza3Cheese,pizza3Ingredient);
		//2. Test add + getAll
		pizzaManager.addPizza(pizza1);   	
		pizzaManager.modPizza(pizza2);
		pizzaManager.addPizza(pizza3);
		System.out.println("Test addPizza + getAllPizzas : ");
		pizzaManager.getAllPizzas().forEach(System.out::println);
		//3. Test mod + Pizza créée
		Pizza pizzaDelTest = new Pizza("PizzaDelTest", false,false,tomato,pizza1Cheese,pizza3Ingredient);
		Double pizzaDelTestPrice = pizzaManager.getPizzaPrice(pizzaDelTest);
		pizzaDelTest.setPrice(pizzaDelTestPrice);
		pizzaManager.modPizza(pizzaDelTest);
	    System.out.println("Test modPizza + getPizzaPrice : ");
	    System.out.println(pizzaDelTestPrice);
	    pizzaManager.getAllPizzas().forEach(System.out::println);
	    //4. Test del
	    pizzaManager.delPizza(4);
	    System.out.println("Test delPizza : ");
	    pizzaManager.getAllPizzas().forEach(System.out::println);
	    //5. Test getPizzaById
	    System.out.println("Test getPizzaById : ");
	    System.out.println(pizzaManager.getPizzaById(1));
	    //6. Test getFoodByPizza
	    System.out.println("Test getFoodByPizza : ");
		System.out.println(pizzaManager.getFoodByPizza(pizza1));
		System.out.println();
		
		// CART
		System.out.println("CART");
		//1. Création
		Cart cart1 = new Cart();
		cart1.getListPizza().add(pizza1);
		cart1.getListPizza().add(pizza2);
		cart1.getListPizza().add(pizza3);
		System.out.println("Test création : ");
		System.out.println(cart1);
		cart1.getListPizza().forEach(System.out::println);
		//2. Test getTotalPrice
		System.out.println("Test getTotalPrice : ");
		System.out.println(cartManager.getTotalPrice(cart1));
		System.out.println();      
		
		// REDUCTIONCODE
		System.out.println("REDUCTION CODE");
		//1. Création
		ReductionCode code1 = new ReductionCode("CODE10POURCENT",0.10);
		//2. Test add + getAll
		System.out.println("Test addReductionCode + getAllReductionCode : ");
		reductionCodeManager.addReductionCode(code1);
		reductionCodeManager.getAllReductionCodes().forEach(System.out::println);
		//3. Test mod
		System.out.println("Test modReductionCode : ");
		ReductionCode reductionCodeDelTest = new ReductionCode("ReductionCodeDelTest",0.50);
		reductionCodeManager.addReductionCode(reductionCodeDelTest);
		reductionCodeManager.getAllReductionCodes().forEach(System.out::println);
		//4. Test del
		System.out.println("Test delReductionCode : ");
		reductionCodeManager.delReductionCode(2);
		reductionCodeManager.getAllReductionCodes().forEach(System.out::println);
		//5. Test getReductionCodeById
		System.out.println("Test getReductionCodeById : ");
	    System.out.println(reductionCodeManager.getReductionCodeById(1));
		System.out.println();
		
		// CUSTOMER
		System.out.println("CUSTOMER");
		//1. Création
		Customer customer1 = new Customer("Bouchard", "Gérard", "10 rue des Mouettes", "29000", "QUIMPER");
		//2. Test add + getAll
		System.out.println("Test addCustomer + getAllCustomers : ");
		customerManager.addCustomer(customer1);
//		customerManager.getAllCustomers().forEach(System.out::println);
		//3. Test mod
		System.out.println("Test modCustomer : ");
		Customer customerDelTest = new Customer("customerDelTest", "customerDelTest", "1 rue du général de Gaulle", "29200", "BREST");
		customerManager.modCustomer(customerDelTest);
//		customerManager.getAllCustomers().forEach(System.out::println);
		//4. Test del
		// BUG
		System.out.println("Test delCustomer : ");
		customerManager.delCustomer(2);
//		customerManager.getAllCustomers().forEach(System.out::println);
		//5. Test getCustomerById
		System.out.println("Test getCustomerById : ");
//	    System.out.println(customerManager.getCustomerById(1));
		System.out.println();
		
		// PIZZA ORDER
		System.out.println("PIZZA ORDER");
		//1. Création : Test setPizzaOrder
		PizzaOrder pizzaOrder1 = pizzaOrderManager.setPizzaOrder(cart1, customer1, code1);
		//2. test add + getAll
		System.out.println("Test addPizzaOrder + getAllPizzaOrders : ");
		pizzaOrderManager.addPizzaOrder(pizzaOrder1);
//		pizzaOrderManager.getAllPizzaOrders().forEach(System.out::println);
		//3. Test mod
		PizzaOrder pizzaOrderDelTest = pizzaOrderManager.setPizzaOrder(cart1, customer1, code1);
		System.out.println("Test modPizzaOrder : ");
		pizzaOrderManager.modPizzaOrder(pizzaOrderDelTest);
//		pizzaOrderManager.getAllPizzaOrders().forEach(System.out::println);
		//4. Test del
		System.out.println("Test delPizzaOrder : ");
		pizzaOrderManager.delPizzaOrder(2);
//		pizzaOrderManager.getAllPizzaOrders().forEach(System.out::println);	
		//5. Test getPizzaOrderById
		System.out.println("Test getPizzaOrderById : ");
//		System.out.println(pizzaOrderManager.getPizzaOrderById(1));
		//6. Test getTotalPrice
		System.out.println("Test getTotalPrice :");
		System.out.println(pizzaOrderManager.getTotalPrice(pizzaOrder1));
		    
	}

}
