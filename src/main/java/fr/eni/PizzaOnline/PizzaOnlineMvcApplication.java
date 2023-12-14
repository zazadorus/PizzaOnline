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
	    Cheese cheeseDelTest = new Cheese ("CheeseDelTest", cheesePrice);
	    //2. Test add + getAll
	    cheeseManager.addCheese(brie);
	    cheeseManager.addCheese(mozzarella);
	    cheeseManager.addCheese(goatCheese);
	    cheeseManager.addCheese(emmental);
	    cheeseManager.addCheese(gorgonzola);
	    cheeseManager.addCheese(cheeseDelTest);
	    System.out.println("Test addCheese + getAllCheeses : ");
	    cheeseManager.getAllCheeses().forEach(System.out::println);
	    //3. Test mod    
	    for (Cheese cheese : cheeseManager.getAllCheeses()) {
			if (cheese.getId()==6) {
				cheese.setWording("CheeseDelTestMod");
				cheeseManager.modCheese(cheese);
			}
		}
	    System.out.println("Test modCheese : ");
	    cheeseManager.getAllCheeses().forEach(System.out::println);
	    //4. Test del
	    for (Cheese cheese : cheeseManager.getAllCheeses()) {
			if (cheese.getId()==6) {
				cheeseManager.delCheese(cheese.getId());
			}
		}
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
		Ingredient ingredientDelTest = new Ingredient ("IngredientDelTest", cheesePrice);
		//2. Test add + getAll
		ingredientManager.addIngredient(bacon);
		ingredientManager.addIngredient(pineapple);
		ingredientManager.addIngredient(kebab);
		ingredientManager.addIngredient(olives);
		ingredientManager.addIngredient(salmon);
		ingredientManager.addIngredient(prune);
		ingredientManager.addIngredient(coypu);
		ingredientManager.addIngredient(ingredientDelTest);
		System.out.println("Test addIngredient + getAllIngredient : ");
		ingredientManager.getAllIngredients().forEach(System.out::println);
		//3. Test mod
	    for (Ingredient ingredient : ingredientManager.getAllIngredients()) {
			if (ingredient.getId()==102) {
				ingredient.setWording("IngredientDelMod");
				ingredientManager.modIngredient(ingredient);
			}
		}
	    System.out.println("Test modIngredient : ");
	    ingredientManager.getAllIngredients().forEach(System.out::println);
	    //4. Test del
	    for (Ingredient ingredient : ingredientManager.getAllIngredients()) {
			if (ingredient.getId()==102) {
				ingredientManager.delIngredient(ingredient.getId());
			}
		}
	    System.out.println("Test delIngredient : ");
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
		Base baseDelTest = new Base ("BaseDelTest", 4.0);
		//2. Test add + getAll
		baseManager.addBase(tomato);
		baseManager.addBase(cream);
		baseManager.addBase(baseDelTest);
		System.out.println("Test addbase + getAllBases : ");
		baseManager.getAllBases().forEach(System.out::println);
		//3. Test mod
	    for (Base base : baseManager.getAllBases()) {
			if (base.getId()==302) {
				base.setWording("BaseDelMod");
				baseManager.modBase(base);
			}
		}
	    System.out.println("Test modbase : ");
	    baseManager.getAllBases().forEach(System.out::println);
	    //4. Test del
	    for (Base base : baseManager.getAllBases()) {
			if (base.getId()==302) {
				baseManager.delBase(base.getId());
			}
		}
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
		Pizza pizzaDeltest = new Pizza("PizzaDelTest", true,true,5.0,baseManager.getBaseById(16),pizza3Cheese,pizza3Ingredient);
		Pizza pizzaCreated = new Pizza("PizzaCreated", true,true,tomato,pizza1Cheese,pizza3Ingredient);
		Double pizzaCreatedPrice = pizzaManager.getPizzaPrice(pizzaCreated);
		pizzaCreated.setPrice(pizzaCreatedPrice);
		//2. Test add + getAll + getPizzaPrice
		pizzaManager.addPizza(pizza1);   	
		pizzaManager.addPizza(pizza2);
		pizzaManager.addPizza(pizza3);
		pizzaManager.addPizza(pizzaDeltest);
		pizzaManager.addPizza(pizzaCreated);
		System.out.println("Test addPizza + getAllPizzas + getPizzaPrice : ");
		pizzaManager.getAllPizzas().forEach(System.out::println);
		System.out.println(pizzaCreatedPrice);
		//3. Test mod
		for (Pizza pizza : pizzaManager.getAllPizzas()) {
			if (pizza.getId()==4) {
				pizza.setName("PizzaDelMod");
				pizzaManager.modPizza(pizza);
			}
		}
		System.out.println("Test modPizza + getPizzaPrice : ");
	    pizzaManager.getAllPizzas().forEach(System.out::println);
	    //4. Test del
	    for (Pizza pizza : pizzaManager.getAllPizzas()) {
			if (pizza.getId()==956) {
				pizzaManager.delPizza(pizza.getId());
			}
		}
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
		ReductionCode reductionCodeDelTest = new ReductionCode("ReductionCodeDelTest",0.50);
		//2. Test add + getAll
		System.out.println("Test addReductionCode + getAllReductionCode : ");
		reductionCodeManager.addReductionCode(code1);
		reductionCodeManager.addReductionCode(reductionCodeDelTest);
		reductionCodeManager.getAllReductionCodes().forEach(System.out::println);
		//3. Test mod
	    for (ReductionCode reductionCode : reductionCodeManager.getAllReductionCodes()) {
			if (reductionCode.getId()==2) {
				reductionCode.setCodeReduction("ReductionCodeDelMod");
				reductionCodeManager.modReductionCode(reductionCode);
			}
		}
		System.out.println("Test modReductionCode : ");
		reductionCodeManager.getAllReductionCodes().forEach(System.out::println);
		//4. Test del
	    for (ReductionCode reductionCode : reductionCodeManager.getAllReductionCodes()) {
			if (reductionCode.getId()==102) {
				reductionCodeManager.delReductionCode(reductionCode.getId());
			}
		}
	    System.out.println("Test delReductionCode : ");
		reductionCodeManager.getAllReductionCodes().forEach(System.out::println);
		//5. Test getReductionCodeById
		System.out.println("Test getReductionCodeById : ");
	    System.out.println(reductionCodeManager.getReductionCodeById(1));
		System.out.println();
		
		// CUSTOMER
		System.out.println("CUSTOMER");
		//1. Création
		Customer customer1 = new Customer("Bouchard", "Gérard", "10 rue des Mouettes", "29000", "QUIMPER");
		Customer customerDelTest = new Customer("customerDelTest", "customerDelTest", "1 rue du général de Gaulle", "29200", "BREST");
		//2. Test add + getAll
		System.out.println("Test addCustomer + getAllCustomers : ");
		customerManager.addCustomer(customer1);
		customerManager.addCustomer(customerDelTest);
		customerManager.getAllCustomers().forEach(System.out::println);
		//3. Test mod
	    for (Customer customer : customerManager.getAllCustomers()) {
			if (customer.getId()==2) {
				customer.setLastname("customerDelMod");
				customerManager.modCustomer(customer);
			}
		}
		System.out.println("Test modCustomer : ");
		customerManager.getAllCustomers().forEach(System.out::println);
		//4. Test del
		// BUG
		for (Customer customer : customerManager.getAllCustomers()) {
			if (customer.getId()==52) {
				customerManager.delCustomer(customer.getId());
			}
		}
		System.out.println("Test delCustomer : ");
		customerManager.getAllCustomers().forEach(System.out::println);
		//5. Test getCustomerById
		System.out.println("Test getCustomerById : ");
	    System.out.println(customerManager.getCustomerById(1));
		System.out.println();
		
		// PIZZA ORDER
		System.out.println("PIZZA ORDER");
		//1. Création : Test setPizzaOrder
		PizzaOrder pizzaOrder1 = pizzaOrderManager.setPizzaOrder(cart1, customer1, code1);
		PizzaOrder pizzaOrder2 = pizzaOrderManager.setPizzaOrder(cart1, customer1, code1);
		PizzaOrder pizzaOrderDelTest = pizzaOrderManager.setPizzaOrder(cart1, customer1, code1);
		//2. test add + getAll
		System.out.println("Test addPizzaOrder + getAllPizzaOrders : ");
		pizzaOrderManager.addPizzaOrder(pizzaOrder1);
		pizzaOrderManager.addPizzaOrder(pizzaOrder2);
		pizzaOrderManager.addPizzaOrder(pizzaOrderDelTest);
		pizzaOrderManager.getAllPizzaOrders().forEach(System.out::println);
		//3. Test mod
		System.out.println("Test modPizzaOrder : ");
	    for (PizzaOrder pizzaOrder : pizzaOrderManager.getAllPizzaOrders()) {
			if (pizzaOrder.getId()==252) {
				pizzaOrder.setDeliveryHour("deliveryHourDelMod");
				pizzaOrderManager.modPizzaOrder(pizzaOrder);
			}
		}
		pizzaOrderManager.getAllPizzaOrders().forEach(System.out::println);
		//4. Test del
	    for (PizzaOrder pizzaOrder : pizzaOrderManager.getAllPizzaOrders()) {
			if (pizzaOrder.getId()==252) {
				pizzaOrderManager.delPizzaOrder(pizzaOrder.getId());
			}
		}
		System.out.println("Test delPizzaOrder : ");
		pizzaOrderManager.getAllPizzaOrders().forEach(System.out::println);	
		//5. Test getPizzaOrderById
		System.out.println("Test getPizzaOrderById : ");
		System.out.println(pizzaOrderManager.getPizzaOrderById(1));
		//6. Test getTotalPrice
		System.out.println("Test getTotalPrice :");
		System.out.println(pizzaOrderManager.getTotalPrice(pizzaOrder1));
		    
	}

}
