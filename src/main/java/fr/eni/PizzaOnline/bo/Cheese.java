package fr.eni.PizzaOnline.bo;

import jakarta.persistence.Entity;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
public class Cheese extends Food {
	
	public Cheese(String wording, Double price) {
		super(wording, price);
		// TODO Auto-generated constructor stub
	}

}
