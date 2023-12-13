package fr.eni.PizzaOnline.bll;

import java.util.List;

import fr.eni.PizzaOnline.bo.ReductionCode;

public interface ReductionCodeManager {

	public void addReductionCode(ReductionCode reductionCode);
	
	public void modReductionCode(ReductionCode reductionCode);
	
	public void delReductionCode(Integer id);
	
	public List<ReductionCode> getAllReductionCodes();
	
	public ReductionCode getReductionCodeById(Integer id);
	
}
