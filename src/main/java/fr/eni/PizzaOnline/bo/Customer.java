package fr.eni.PizzaOnline.bo;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
public class Customer {

	@Id
	@GeneratedValue
	private Integer id;
	private String civility;
	private String lastname;
	private String firstname;
	private String email;
	private String telephone;
	private String password;
	private String adress;
	private String postalCode;
	private String city;
	private String society;
	private String floor;
	private String building;
	private String elevator;
	private String intercom;
	private String digicode1;
	private String digicode2;
	private String instruction;
	@OneToMany 
	private List<PizzaOrder> pizzaOrder = new ArrayList<>();

	public Customer(String lastname, String firstname, String adress, String postalCode, String city) {
		super();
		this.lastname = lastname;
		this.firstname = firstname;
		this.adress = adress;
		this.postalCode = postalCode;
		this.city = city;
	}

}
