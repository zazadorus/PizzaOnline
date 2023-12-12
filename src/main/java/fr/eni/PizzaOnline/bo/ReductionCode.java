package fr.eni.PizzaOnline.bo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
public class ReductionCode {

	@Id
	@GeneratedValue
	private Long id;
	private String codeReduction;
	private Double amountReduction;
	
	public ReductionCode(String codeReduction, Double amountReduction) {
		super();
		this.codeReduction = codeReduction;
		this.amountReduction = amountReduction;
	}
}
