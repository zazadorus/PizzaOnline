package fr.eni.PizzaOnline.bo;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
public class Cart {

	@Id
	@GeneratedValue
	private Integer id;
	@ManyToMany
	private List<Pizza> listPizza = new ArrayList<>();
	
	public Cart(List<Pizza> listPizza) {
		super();
		this.listPizza = listPizza;
	}	

}
