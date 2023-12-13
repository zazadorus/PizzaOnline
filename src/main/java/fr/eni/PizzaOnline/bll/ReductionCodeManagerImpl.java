package fr.eni.PizzaOnline.bll;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.eni.PizzaOnline.bo.ReductionCode;
import fr.eni.PizzaOnline.dal.ReductionCodeDAO;

@Service
public class ReductionCodeManagerImpl implements ReductionCodeManager{

	@Autowired
	ReductionCodeDAO reductionCodeDAO;
	
	@Override
	// TEST : OK
	public void addReductionCode(ReductionCode reductionCode) {
		reductionCodeDAO.save(reductionCode);
	}

	@Override
	// TEST : NOK
	public void modReductionCode(ReductionCode reductionCode) {
		reductionCodeDAO.save(reductionCode);
	}

	@Override
	// TEST : OK
	public void delReductionCode(Integer id) {
		ReductionCode reductionCode = getReductionCodeById(id);
		reductionCodeDAO.delete(reductionCode);
	}

	@Override
	// TEST : OK
	public List<ReductionCode> getAllReductionCodes() {
		return (List<ReductionCode>) reductionCodeDAO.findAll();
	}

	@Override
	// TEST : OK
	public ReductionCode getReductionCodeById(Integer id) {
		return reductionCodeDAO.findById(id).orElse(null);
	}


	
}
