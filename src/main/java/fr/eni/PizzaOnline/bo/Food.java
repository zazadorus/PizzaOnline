package fr.eni.PizzaOnline.bo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Food {
	
	@Id
	@GeneratedValue
	private Long id;
	private String wording;
	private Double price;
	
	public Food(String wording, Double price) {
		super();
		this.wording = wording;
		this.price = price;
	}
	
	

}
