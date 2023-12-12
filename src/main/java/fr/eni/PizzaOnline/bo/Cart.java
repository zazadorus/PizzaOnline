package fr.eni.PizzaOnline.bo;

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
	private Long id;
	@ManyToMany
	private List listPizza;

}
