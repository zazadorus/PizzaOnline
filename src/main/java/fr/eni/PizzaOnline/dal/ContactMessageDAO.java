package fr.eni.PizzaOnline.dal;

import org.springframework.data.repository.CrudRepository;

import fr.eni.PizzaOnline.bo.ContactMessage;

public interface ContactMessageDAO extends CrudRepository<ContactMessage, Integer>{

}
