package fr.eni.PizzaOnline.bll;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.eni.PizzaOnline.bo.Base;
import fr.eni.PizzaOnline.dal.BaseDAO;

@Service
public class BaseManagerImpl implements BaseManager{

	@Autowired
	BaseDAO baseDAO;
	
	@Override
	// TEST : OK
	public void addBase(Base base) {
		baseDAO.save(base);
		
	}

	@Override
	// TEST : NOK
	public void modBase(Base base) {
		baseDAO.save(base);
		
	}

	@Override
	// TEST : OK
	public void delBase(Integer id) {
		Base base = getBaseById(id);
		baseDAO.delete(base);
		
	}

	@Override
	// TEST : OK
	public List<Base> getAllBases() {
		return (List<Base>) baseDAO.findAll();
	}

	@Override
	// TEST : OK
	public Base getBaseById(Integer id) {
		return baseDAO.findById(id).orElse(null);
	}

}
