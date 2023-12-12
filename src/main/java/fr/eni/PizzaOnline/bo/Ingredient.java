package fr.eni.PizzaOnline.bo;

public class Ingredient extends Food {
	
	final static double price = 1;

	public Ingredient( String wording) {
		super(wording, price);
	}

}
