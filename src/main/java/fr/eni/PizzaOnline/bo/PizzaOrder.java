package fr.eni.PizzaOnline.bo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
public class PizzaOrder {
	
	@Id
	@GeneratedValue
	private Integer id;
	private LocalDate deliveryDate;
	private String deliveryHour;
	private LocalDate orderDate;
	private String orderHour;
	@ManyToOne
	private ReductionCode reductionCode;
	@ManyToMany (cascade=CascadeType.MERGE, fetch = FetchType.EAGER)
	private List<Pizza> listPizza = new ArrayList<>();
	@ManyToOne
	private Customer customer;
	
	public PizzaOrder(LocalDate deliveryDate, String deliveryHour, LocalDate orderDate, String orderHour,
			ReductionCode reductionCode, List<Pizza> listPizza, Customer customer) {
		super();
		this.deliveryDate = deliveryDate;
		this.deliveryHour = deliveryHour;
		this.orderDate = orderDate;
		this.orderHour = orderHour;
		this.reductionCode = reductionCode;
		this.listPizza = listPizza;
		this.customer = customer;
	}
	
}
