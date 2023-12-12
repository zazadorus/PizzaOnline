package fr.eni.PizzaOnline.bo;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
public class Pizza {
	
	@Id
	@GeneratedValue
	private Long id;
	private String name;
	private Boolean availableTakeAway;
	private Boolean availableOnSite;
	private Double price;
	private String imageLink;
	@ManyToOne
	private Base base;
	@ManyToMany
	private List listCheese;
	@ManyToMany
	private List listIngredient;
	
	public Pizza(String name, Boolean availableTakeAway, Boolean availableOnSite, Double price, Base base, List listCheese, List listIngredient) {
		super();
		this.name = name;
		this.availableTakeAway = availableTakeAway;
		this.availableOnSite = availableOnSite;
		this.price = price;
		this.base = base;
		this.listCheese = listCheese;
		this.listIngredient = listIngredient;
	}
	
}
