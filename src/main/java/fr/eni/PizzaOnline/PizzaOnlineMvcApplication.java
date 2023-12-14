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
//		initializeFood();
	}

	public static void main(String[] args) {
		SpringApplication.run(PizzaOnlineApplication.class, args);
	}

	private void initializeFood() {

		// CHEESE
		System.out.println("CHEESE");
		// 1. Création
		Double cheesePrice = 1.0;
		Cheese mozzarella = new Cheese("Mozzarella", cheesePrice);
		Cheese emmental = new Cheese("Emmental", cheesePrice);
		Cheese goatCheese = new Cheese("Chèvre", cheesePrice);
		Cheese brie = new Cheese("Brie de Meaux", cheesePrice);
		Cheese gorgonzola = new Cheese("Gorgonzola AOP", cheesePrice);
		Cheese parmesan = new Cheese("Parmesan", cheesePrice);
		Cheese reblochon = new Cheese("Reblochon", cheesePrice);
		// 2. Test add + getAll
		cheeseManager.addCheese(mozzarella);
		cheeseManager.addCheese(emmental);
		cheeseManager.addCheese(goatCheese);
		cheeseManager.addCheese(brie);
		cheeseManager.addCheese(gorgonzola);
		cheeseManager.addCheese(parmesan);
		cheeseManager.addCheese(reblochon);
		System.out.println("getAllCheeses : ");
		cheeseManager.getAllCheeses().forEach(System.out::println);

		// INGREDIENT
		System.out.println("INGREDIENT");
		// 1. Création
		Double ingredientPrice = 1.0;
		Ingredient jambon = new Ingredient("Jambon", ingredientPrice);
		Ingredient jambonDeParme = new Ingredient("Jambon de Parme", ingredientPrice);
		Ingredient mushroom = new Ingredient("Champignon", ingredientPrice);
		Ingredient egg = new Ingredient("Oeuf", ingredientPrice);
		Ingredient bellPepper = new Ingredient("Poivron", ingredientPrice);
		Ingredient zucchini = new Ingredient("Courgette", ingredientPrice);
		Ingredient eggPlant = new Ingredient("Aubergine", ingredientPrice);
		Ingredient chicken = new Ingredient("Poulet", ingredientPrice);
		Ingredient merguez = new Ingredient("Merguez", ingredientPrice);
		Ingredient groundBeef = new Ingredient("Boeuf haché", ingredientPrice);
		Ingredient cream = new Ingredient("Crème", ingredientPrice);
		Ingredient potatoe = new Ingredient("Pomme de terre", ingredientPrice);
		Ingredient bacon = new Ingredient("Bacon", ingredientPrice);
		Ingredient pineapple = new Ingredient("Ananas", ingredientPrice);
		Ingredient kebab = new Ingredient("Viande de Kebab", ingredientPrice);
		Ingredient olives = new Ingredient("Olives Kalamata", ingredientPrice);
		Ingredient salmon = new Ingredient("Saumon fumé", ingredientPrice);
		Ingredient prune = new Ingredient("Pruneau d'Agen", ingredientPrice);
		Ingredient coypu = new Ingredient("Ragondin", ingredientPrice);
		// 2. Test add + getAll
		ingredientManager.addIngredient(jambon);
		ingredientManager.addIngredient(jambonDeParme);
		ingredientManager.addIngredient(mushroom);
		ingredientManager.addIngredient(egg);
		ingredientManager.addIngredient(bellPepper);
		ingredientManager.addIngredient(zucchini);
		ingredientManager.addIngredient(eggPlant);
		ingredientManager.addIngredient(chicken);
		ingredientManager.addIngredient(merguez);
		ingredientManager.addIngredient(groundBeef);
		ingredientManager.addIngredient(cream);
		ingredientManager.addIngredient(potatoe);
		ingredientManager.addIngredient(bacon);
		ingredientManager.addIngredient(pineapple);
		ingredientManager.addIngredient(kebab);
		ingredientManager.addIngredient(olives);
		ingredientManager.addIngredient(salmon);
		ingredientManager.addIngredient(prune);
		ingredientManager.addIngredient(coypu);

		System.out.println("getAllIngredient : ");
		ingredientManager.getAllIngredients().forEach(System.out::println);

		// BASE
		System.out.println("BASE");
		// 1. Création
		Base tomatoBase = new Base("Base tomate", 5.0);
		Base creamBase = new Base("Base crème", 6.0);
		// 2. Add + getAll
		baseManager.addBase(tomatoBase);
		baseManager.addBase(creamBase);

		System.out.println("getAllBases : ");
		baseManager.getAllBases().forEach(System.out::println);

		// Création des listes

		// pizza 1
		List<Cheese> pizza1Cheese = new ArrayList<>();
		pizza1Cheese.add(mozzarella);
		List<Ingredient> pizza1Ingredient = new ArrayList<>();
		pizza1Ingredient.add(jambon);
		pizza1Ingredient.add(mushroom);
		pizza1Ingredient.add(olives);

		// pizza 2
		List<Cheese> pizza2Cheese = new ArrayList<>();
		pizza2Cheese.add(mozzarella);
		pizza2Cheese.add(gorgonzola);
		List<Ingredient> pizza2Ingredient = new ArrayList<>();
		pizza2Ingredient.add(eggPlant);
		pizza2Ingredient.add(zucchini);
		pizza2Ingredient.add(bellPepper);

		// pizza 3
		List<Cheese> pizza3Cheese = new ArrayList<>();
		pizza3Cheese.add(mozzarella);
		List<Ingredient> pizza3Ingredient = new ArrayList<>();
		pizza3Ingredient.add(merguez);
		pizza3Ingredient.add(egg);
		pizza3Ingredient.add(bellPepper);

		// pizza 4
		List<Cheese> pizza4Cheese = new ArrayList<>();
		pizza4Cheese.add(mozzarella);
		List<Ingredient> pizza4Ingredient = new ArrayList<>();
		pizza4Ingredient.add(potatoe);
		pizza4Ingredient.add(jambon);
		pizza4Ingredient.add(mushroom);

		// pizza 5
		List<Cheese> pizza5Cheese = new ArrayList<>();
		pizza5Cheese.add(mozzarella);
		pizza5Cheese.add(reblochon);
		List<Ingredient> pizza5Ingredient = new ArrayList<>();
		pizza5Ingredient.add(potatoe);
		pizza5Ingredient.add(jambon);
		pizza5Ingredient.add(jambonDeParme);

		// pizza 6
		List<Cheese> pizza6Cheese = new ArrayList<>();
		pizza6Cheese.add(mozzarella);
		List<Ingredient> pizza6Ingredient = new ArrayList<>();
		pizza6Ingredient.add(groundBeef);
		pizza6Ingredient.add(mushroom);
		pizza6Ingredient.add(olives);

		// pizza 7
		List<Cheese> pizza7Cheese = new ArrayList<>();
		pizza7Cheese.add(mozzarella);
		List<Ingredient> pizza7Ingredient = new ArrayList<>();
		pizza7Ingredient.add(egg);
		pizza7Ingredient.add(coypu);
		pizza7Ingredient.add(pineapple);
		pizza7Ingredient.add(prune);

		// pizza 8
		List<Cheese> pizza8Cheese = new ArrayList<>();
		pizza8Cheese.add(mozzarella);
		List<Ingredient> pizza8Ingredient = new ArrayList<>();
		pizza8Ingredient.add(kebab);
		pizza8Ingredient.add(bellPepper);
		pizza8Ingredient.add(cream);

		// pizza 9
		List<Cheese> pizza9Cheese = new ArrayList<>();
		pizza9Cheese.add(mozzarella);
		List<Ingredient> pizza9Ingredient = new ArrayList<>();
		pizza9Ingredient.add(chicken);
		pizza9Ingredient.add(bellPepper);
		pizza9Ingredient.add(cream);

		// pizza 10
		List<Cheese> pizza10Cheese = new ArrayList<>();
		pizza10Cheese.add(mozzarella);
		pizza10Cheese.add(gorgonzola);
		pizza10Cheese.add(goatCheese);
		pizza10Cheese.add(parmesan);

		List<Ingredient> pizza10Ingredient = new ArrayList<>();
		pizza10Ingredient.add(zucchini);
		pizza10Ingredient.add(eggPlant);
		pizza10Ingredient.add(olives);

		// pizza 11
		List<Cheese> pizza11Cheese = new ArrayList<>();
		pizza11Cheese.add(mozzarella);
		pizza11Cheese.add(gorgonzola);
		List<Ingredient> pizza11Ingredient = new ArrayList<>();
		pizza11Ingredient.add(groundBeef);
		pizza11Ingredient.add(merguez);
		pizza11Ingredient.add(salmon);
		pizza11Ingredient.add(prune);

		// pizza 12
		List<Cheese> pizza12Cheese = new ArrayList<>();
		pizza12Cheese.add(mozzarella);
		List<Ingredient> pizza12Ingredient = new ArrayList<>();
		pizza12Ingredient.add(bacon);
		pizza12Ingredient.add(olives);
		pizza12Ingredient.add(prune);

		// pizza 13
		List<Cheese> pizza13Cheese = new ArrayList<>();
		pizza13Cheese.add(emmental);
		pizza13Cheese.add(gorgonzola);
		pizza13Cheese.add(goatCheese);
		List<Ingredient> pizza13Ingredient = new ArrayList<>();
		pizza13Ingredient.add(pineapple);
		pizza13Ingredient.add(kebab);
		pizza13Ingredient.add(coypu);
		pizza13Ingredient.add(salmon);
		pizza13Ingredient.add(prune);

		// PIZZA
		System.out.println("PIZZA");
		// 1. Création de 11 pizzas
		Pizza pizza1 = new Pizza("Reine", true, true, 8.0, tomatoBase, pizza1Cheese, pizza1Ingredient);
		Pizza pizza2 = new Pizza("Végé", true, true, 9.0, tomatoBase, pizza2Cheese, pizza2Ingredient);
		Pizza pizza3 = new Pizza("Orientale", true, true, 9.5, tomatoBase, pizza3Cheese, pizza3Ingredient);
		Pizza pizza4 = new Pizza("Campagnarde", false, true, 10.0, tomatoBase, pizza4Cheese, pizza4Ingredient);
		Pizza pizza5 = new Pizza("Savoyarde", true, true, 11.0, tomatoBase, pizza5Cheese, pizza5Ingredient);
		Pizza pizza6 = new Pizza("Bolognaise", true, true, 10.0, tomatoBase, pizza6Cheese, pizza6Ingredient);
		Pizza pizza7 = new Pizza("L'exploratrice", false, true, 12.0, tomatoBase, pizza7Cheese, pizza7Ingredient);
		Pizza pizza8 = new Pizza("Kebab", true, true, 10.0, creamBase, pizza8Cheese, pizza8Ingredient);
		Pizza pizza9 = new Pizza("Poulet", true, true, 10.0, creamBase, pizza9Cheese, pizza9Ingredient);
		Pizza pizza10 = new Pizza("4 Fromages légumes", true, true, 9.5, tomatoBase, pizza10Cheese, pizza10Ingredient);
		Pizza pizza11 = new Pizza("Festin des grands jours", true, true, 15.0, creamBase, pizza11Cheese, pizza11Ingredient);
		Pizza pizza12 = new Pizza("Grana Delicioza", true, true, 13.50, creamBase, pizza12Cheese, pizza12Ingredient);
		Pizza pizza13 = new Pizza("Opération gastro", true, true, 15.0, creamBase, pizza13Cheese, pizza13Ingredient);

		pizza1.setImageLink("/images/reine.jpg");
		pizza2.setImageLink("/images/vege.jpg");
		pizza3.setImageLink("/images/orientale.jpg");
		pizza4.setImageLink("/images/campagnarde.jpg");
		pizza5.setImageLink("/images/savoyarde.jpg");
		pizza6.setImageLink("/images/bolognaise.jpg");
		pizza7.setImageLink("/images/gros-bebe.jpg");
		pizza8.setImageLink("/images/kebab.jpg");
		pizza9.setImageLink("/images/poulet.jpg");
		pizza10.setImageLink("/images/4-fromages-legumes.jpg");
		pizza11.setImageLink("/images/festin-des-grands-jours.jpg");
		pizza12.setImageLink("/images/grana-delicioza.jpg");
		pizza13.setImageLink("/images/operation-gastro.jpg");

		// 2. Add + getAll
		pizzaManager.addPizza(pizza1);
		pizzaManager.addPizza(pizza2);
		pizzaManager.addPizza(pizza3);
		pizzaManager.addPizza(pizza4);
		pizzaManager.addPizza(pizza5);
		pizzaManager.addPizza(pizza6);
		pizzaManager.addPizza(pizza7);
		pizzaManager.addPizza(pizza8);
		pizzaManager.addPizza(pizza9);
		pizzaManager.addPizza(pizza10);
		pizzaManager.addPizza(pizza11);
		pizzaManager.addPizza(pizza12);
		pizzaManager.addPizza(pizza13);

		pizzaManager.getAllPizzas().forEach(System.out::println);

		// REDUCTION CODE
		System.out.println("REDUCTION CODE");
		// 1. Création
		ReductionCode code1 = new ReductionCode("CODE10POURCENT", 0.10);
		ReductionCode code2 = new ReductionCode("CODE20POURCENT", 0.20);
		// 2. Test add + getAll
		reductionCodeManager.addReductionCode(code1);
		reductionCodeManager.addReductionCode(code2);
		System.out.println("getAllReductionCode : ");
		reductionCodeManager.getAllReductionCodes().forEach(System.out::println);

		// CUSTOMER
		System.out.println("CUSTOMER");
		// 1. Création
		Customer customer1 = new Customer("Bouchard", "Gérard", "10 rue des Mouettes", "29000", "QUIMPER");
		// 2. Test add + getAll
		customerManager.addCustomer(customer1);
		System.out.println("getAllCustomers : ");
		customerManager.getAllCustomers().forEach(System.out::println);

	}

}
