package fr.eni.PizzaOnline.bo;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class Ingredient extends Food {
	
	final static double PRICE = 1;

	public Ingredient( String wording) {
		super(wording, PRICE);
	}

}
