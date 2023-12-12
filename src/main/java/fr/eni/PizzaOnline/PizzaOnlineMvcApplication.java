package fr.eni.PizzaOnline;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import fr.eni.PizzaOnline.bll.PizzaManager;
import fr.eni.PizzaOnline.bo.Base;
import fr.eni.PizzaOnline.bo.Cheese;
import fr.eni.PizzaOnline.bo.Ingredient;
import fr.eni.PizzaOnline.bo.Pizza;
import jakarta.annotation.PostConstruct;

@SpringBootApplication
public class PizzaOnlineMvcApplication {

	   @Autowired
	    PizzaManager pizzaManager;

	    @PostConstruct
	    public void init() {
	    	initializeFood();
	    }
	    
		public static void main(String[] args) {
			SpringApplication.run(PizzaOnlineApplication.class, args);
		}
	  
	    private void initializeFood() {
	        
	    	Double cheesePrice = 1.0;
	        Cheese brie = new Cheese ("Brie de Meaux", cheesePrice);
	        Cheese mozzarella = new Cheese ("Mozzarella", cheesePrice);
	        Cheese goatCheese = new Cheese ("chèvre", cheesePrice);
	        Cheese emmental = new Cheese ("emmental", cheesePrice);
	        Cheese gorgonzola = new Cheese ("Gorgonzola AOP", cheesePrice);
	        pizzaManager.addCheese(brie);
	        pizzaManager.addCheese(mozzarella);
	        pizzaManager.addCheese(goatCheese);
	        pizzaManager.addCheese(emmental);
	        pizzaManager.addCheese(gorgonzola);

	        Double ingredientPrice = 1.0;
	        Ingredient bacon = new Ingredient ("Bacon", ingredientPrice);
	        Ingredient pineapple = new Ingredient ("Ananas", ingredientPrice);
	        Ingredient kebab = new Ingredient ("Viande de Kebab", ingredientPrice);
	        Ingredient olives = new Ingredient ("Olives Kalamata", ingredientPrice);
	        Ingredient salmon = new Ingredient ("Saumon fumé", ingredientPrice);
	        Ingredient prune = new Ingredient ("Pruneau d'Agean", ingredientPrice);
	        Ingredient coypu = new Ingredient ("Ragondin", ingredientPrice);
	        pizzaManager.addIngredient(bacon);
	        pizzaManager.addIngredient(pineapple);
	        pizzaManager.addIngredient(kebab);
	        pizzaManager.addIngredient(olives);
	        pizzaManager.addIngredient(salmon);
	        pizzaManager.addIngredient(prune);
	        pizzaManager.addIngredient(coypu);
	        
	        Base tomato = new Base ("Base tomate",5.0);
	        Base cream = new Base ("Base crème",6.0);
	        pizzaManager.addBase(tomato);
	        pizzaManager.addBase(cream);
	        
	        //List <Cheese> pizza1Cheese= new ArrayList<brie,goatCheese>;
	        
	        List <Cheese> pizza1Cheese= new ArrayList<>();
	        pizza1Cheese.add(brie);
	        pizza1Cheese.add(goatCheese);
	        
	        //List <Ingredient> pizza1Ingredient= new ArrayList<bacon,olives>;
	        List <Ingredient> pizza1Ingredient= new ArrayList<>();
	        pizza1Ingredient.add(bacon);
	        pizza1Ingredient.add(olives);
	        
	    	//List <Cheese> pizza2Cheese= new ArrayList<gorgonzola,mozzarella>;
	    	List <Cheese> pizza2Cheese= new ArrayList<>();
	    	pizza2Cheese.add(gorgonzola);
	    	pizza2Cheese.add(mozzarella);
	    	
	    	
	    	//List <Ingredient> pizza2Ingredient= new ArrayList<salmon,prune>;
	    	List <Ingredient> pizza2Ingredient= new ArrayList<>();
	    	pizza2Ingredient.add(salmon);
	    	pizza2Ingredient.add(prune);
	    	
	    	//List <Cheese> pizza3Cheese= new ArrayList<emmental,gorgonzola,goatCheese>;
	    	List <Cheese> pizza3Cheese= new ArrayList<>();
	    	pizza3Cheese.add(emmental);
	    	pizza3Cheese.add(gorgonzola);
	    	pizza3Cheese.add(goatCheese);
	    	
	    	//List <Ingredient> pizza3Ingredient= new ArrayList<pineapple,kebab,coypu,salmon,prune>;
	    	List <Ingredient> pizza3Ingredient= new ArrayList<>();
	    	pizza3Ingredient.add(pineapple);
	    	pizza3Ingredient.add(kebab);
	    	pizza3Ingredient.add(coypu);
	    	pizza3Ingredient.add(salmon);
	    	pizza3Ingredient.add(prune);
	    	
	        pizzaManager.addPizza(new Pizza("Festin des grands jours", true,true,15.0,tomato,pizza1Cheese,pizza1Ingredient));   	
	        pizzaManager.addPizza(new Pizza("Grana Delicioza", true,true,13.50,tomato,pizza2Cheese,pizza2Ingredient));
	        pizzaManager.addPizza(new Pizza("Opération gastro", true,true,5.0,cream,pizza3Cheese,pizza3Ingredient));
	        
	        pizzaManager.getAllPizzas().forEach(System.out::println);
	    }

}
