package fr.eni.PizzaOnline.bll;

import java.util.List;

import fr.eni.PizzaOnline.bo.Base;

public interface BaseManager {
	
	public void addBase(Base base);
	
	public void modBase(Base base);
	
	public void delBase(Integer id);
	
	public List<Base> getAllBases();
	
	public Base getBaseById(Integer id);
	

}
