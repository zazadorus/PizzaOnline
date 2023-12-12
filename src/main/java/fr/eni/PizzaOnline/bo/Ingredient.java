package fr.eni.PizzaOnline.bo;

import jakarta.persistence.Entity;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
public class Ingredient extends Food {
	
	public Ingredient(String wording, Double price) {
		super(wording, price);
		// TODO Auto-generated constructor stub
	}
	
}
