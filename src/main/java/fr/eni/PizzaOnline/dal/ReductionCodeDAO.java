package fr.eni.PizzaOnline.dal;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import fr.eni.PizzaOnline.bo.ReductionCode;

public interface ReductionCodeDAO extends CrudRepository<ReductionCode, Integer>{

	@Query("SELECT r FROM ReductionCode r WHERE r.codeReduction = :code")
    ReductionCode findReductionCodeByCode(@Param("code") String code);
	
}
