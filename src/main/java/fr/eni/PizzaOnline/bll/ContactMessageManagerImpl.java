package fr.eni.PizzaOnline.bll;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.eni.PizzaOnline.bo.ContactMessage;
import fr.eni.PizzaOnline.dal.ContactMessageDAO;

@Service
public class ContactMessageManagerImpl implements ContactMessageManager{

	@Autowired
	ContactMessageDAO contactMessageDAO;
	
	@Override
	public void addContactMessage(ContactMessage contactMessage) {
		contactMessageDAO.save(contactMessage);		
	}

	@Override
	public void delContactMessage(Integer id) {
		ContactMessage contactMessage = getContactMessageById(id);
		contactMessageDAO.delete(contactMessage);
	}

	@Override
	public List<ContactMessage> getAllContactMessages() {
		return (List<ContactMessage>) contactMessageDAO.findAll();
	}

	@Override
	public ContactMessage getContactMessageById(Integer id) {
		return contactMessageDAO.findById(id).orElse(null);
	}

}
