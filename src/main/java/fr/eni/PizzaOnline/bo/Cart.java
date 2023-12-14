package fr.eni.PizzaOnline.bo;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.ManyToMany;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Cart {

	@ManyToMany
	private List<Pizza> listPizza = new ArrayList<>();
	
	public Cart(List<Pizza> listPizza) {
		super();
		this.listPizza = listPizza;
	}	

}
