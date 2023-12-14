package fr.eni.PizzaOnline.bll;

import java.util.List;

import fr.eni.PizzaOnline.bo.ContactMessage;

public interface ContactMessageManager {

	public void addContactMessage(ContactMessage contactMessage);
	
	public void delContactMessage(Integer id);
	
	public List<ContactMessage> getAllContactMessages();
	
	public ContactMessage getContactMessageById(Integer id);
	
}
