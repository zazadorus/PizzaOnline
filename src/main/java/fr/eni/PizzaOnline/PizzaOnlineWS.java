package fr.eni.PizzaOnline;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.eni.PizzaOnline.bo.Base;
import fr.eni.PizzaOnline.bo.Cheese;
import fr.eni.PizzaOnline.bo.Ingredient;
import fr.eni.PizzaOnline.bo.Pizza;
import jakarta.annotation.PostConstruct;


@RestController
@RequestMapping("/")
public class PizzaOnlineWS {
    
   
    @Autowired
    PizzaManager pizzaManager;

    @PostConstruct
    public void init() {
    	initializeFood();
    }
    
  
    private void initializeFood() {
        
        Cheese brie = new Cheese ("Brie de Meaux");
        Cheese mozzarella = new Cheese ("Mozzarella");
        Cheese goatCheese = new Cheese ("chèvre");
        Cheese emmental = new Cheese ("emmental");
        Cheese gorgonzola = new Cheese ("Gorgonzola AOP");
        
        Ingredient bacon = new Ingredient ("Bacon");
        Ingredient pineapple = new Ingredient ("Ananas");
        Ingredient kebab = new Ingredient ("Viande de Kebab");
        Ingredient olives = new Ingredient ("Olives Kalamata");
        Ingredient salmon = new Ingredient ("Saumon fumé");
        Ingredient prune = new Ingredient ("Pruneau d'Agean");
        Ingredient coypu = new Ingredient ("Ragondin");
        
        Base tomato = new Base ("Base tomate",5.0);
        Base cream = new Base ("Base crème",6.0);
        
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
    }

}