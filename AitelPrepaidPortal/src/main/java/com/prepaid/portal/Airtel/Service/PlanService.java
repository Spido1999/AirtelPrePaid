package com.prepaid.portal.Airtel.Service;

import java.util.List;

import com.prepaid.portal.Airtel.Model.Plan;

public interface PlanService {

	
	Plan createPlan(Plan plan);
	
	List<Plan> getAllPlan();
	
	Plan getByPlanId(Long planId);
	
	Plan getByPlanName(String planName);
	
	Plan updateById(Plan updatePlan, Long planId);
	
	void deleteById(Long planId);
}
