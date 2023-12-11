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


import jakarta.annotation.PostConstruct;


@RestController
@RequestMapping("/")
public class PizzaOnlineWS {
    
   
    @Autowired
    PizzaManager pizzaManager;

    @PostConstruct
    public void init() {
    	initializeFood();
    	
        pizzaManager.addPizza(new Pizza("Festin des grands jours", true,true,15,tomato,pizza1Cheese,pizza1Ingredient));   	
        pizzaManager.addPizza(new Pizza("Grana Delicioza", true,true,13.50,tomato,pizza2Cheese,pizza2Ingredient));
        pizzaManager.addPizza(new Pizza("Opération gastro", true,true,5,cream,pizza3Cheese,pizza3Ingredient));
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
        
        Base tomato = new Base ("Base tomate",5);
        Base cream = new Base ("Base crème",5);
        
        List <Cheese> pizza1Cheese= new ArrayList<brie,goatCheese>;
    	List <Ingredient> pizza1Ingredient= new ArrayList<bacon,olives>;
    	
    	List <Cheese> pizza2Cheese= new ArrayList<gorgonzola,mozzarella>;
    	List <Ingredient> pizza2Ingredient= new ArrayList<salmon,prune>;
    	
    	List <Cheese> pizza3Cheese= new ArrayList<emmental,gorgonzola,goatCheese>;
    	List <Ingredient> pizza3Ingredient= new ArrayList<pineapple,kebab,coypu,salmon,prune>;
    }

}