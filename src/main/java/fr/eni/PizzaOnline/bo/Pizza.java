package fr.eni.PizzaOnline.bo;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import fr.eni.PizzaOnline.bo.Base;

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
	@ManyToOne(cascade=CascadeType.MERGE, fetch = FetchType.EAGER)
	@JoinColumn(name="base_id")
	private Base base;
	@ManyToMany(cascade=CascadeType.MERGE, fetch=FetchType.EAGER)
	private List<Cheese> listCheese;
	@ManyToMany(cascade=CascadeType.MERGE, fetch=FetchType.EAGER)
	private List<Ingredient> listIngredient;
	
	public Pizza(String name, Boolean availableTakeAway, Boolean availableOnSite, Double price, Base base, List<Cheese> listCheese, List<Ingredient> listIngredient) {
		super();
		this.name = name;
		this.availableTakeAway = availableTakeAway;
		this.availableOnSite = availableOnSite;
		this.price = price;
		this.base = base;
		this.listCheese = listCheese;
		this.listIngredient = listIngredient;
	}

	public Pizza(String name, Boolean availableTakeAway, Boolean availableOnSite, Base base, List<Cheese> listCheese, List<Ingredient> listIngredient) {
		super();
		this.name = name;
		this.availableTakeAway = availableTakeAway;
		this.availableOnSite = availableOnSite;
		this.base = base;
		this.listCheese = listCheese;
		this.listIngredient = listIngredient;
	}
	
}
