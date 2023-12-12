package fr.eni.PizzaOnline.bo;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class Cheese extends Food {
	
	final static double PRICE = 1;

	public Cheese(String wording) {
		super(wording, PRICE);
	}


}
