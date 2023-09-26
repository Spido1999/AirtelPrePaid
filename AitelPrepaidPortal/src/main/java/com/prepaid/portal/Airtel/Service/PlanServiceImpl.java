package com.prepaid.portal.Airtel.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prepaid.portal.Airtel.Exception.DuplicatePlanNameException;
import com.prepaid.portal.Airtel.Exception.IncompletePlanDataException;
import com.prepaid.portal.Airtel.Model.Plan;
import com.prepaid.portal.Airtel.Repo.PlanRepo;


@Service
public class PlanServiceImpl implements PlanService {
	
	
	@Autowired
	private PlanRepo planRepo;

	@Override
	public Plan createPlan(Plan plan) {
	    if (plan.getPlanName() == null || plan.getPlanName().isEmpty() ||
	        plan.getPlanCost() == null || plan.getPlanCost().isEmpty() ||
	        plan.getPlanDetails() == null || plan.getPlanDetails().isEmpty()) {
	        throw new IncompletePlanDataException("Plan data is incomplete. All fields (planName, planCost, planDetails) are required.");
	    }
	    Plan existingPlan = getByPlanName(plan.getPlanName());
	    if (existingPlan != null) {
	        throw new DuplicatePlanNameException("A plan with the same name already exists.");
	    }
	    Plan create = new Plan(plan.getPlanName(), plan.getPlanCost(), plan.getPlanDetails());
	    return this.planRepo.save(create);
	}



	@Override
	public List<Plan> getAllPlan() {
		return planRepo.findAll();
	}

	@Override
	public Plan getByPlanId(Long planId) {
		Optional<Plan> planOptional=this.planRepo.findById(planId);
		
		Plan obj=null;
		if(planOptional.isPresent()) {
			System.out.println("Plan Is present");
			obj=planOptional.get();
			
		}
		else {
			System.out.println("Plan Is Not Present");
		}
		return obj;
	}

	@Override
	public Plan getByPlanName(String planName) {
	    Optional<Plan> planOptional = planRepo.findByPlanName(planName);
	    if (planOptional.isPresent()) {
	        System.out.println("Plan Is present");
	        return planOptional.get(); 
	    } else {
	        System.out.println("Plan Is Not Present");
	        return null;
	    }
	}


	@Override
	public Plan updateById(Plan updatePlan, Long planId) {
		Optional<Plan> planOptional=this.planRepo.findById(planId);
		if(planOptional.isPresent()) {
			Plan obj=planOptional.get();
			obj.setPlanName(updatePlan.getPlanName());
			obj.setPlanCost(updatePlan.getPlanCost());
			obj.setPlanDetails(updatePlan.getPlanDetails());
			
			Plan uObj=this.planRepo.save(obj);
			return uObj;
		}
		else {
			return null;
		}
	}

	@Override
	public void deleteById(Long planId) {
		Optional<Plan> planOptional=this.planRepo.findById(planId);
		if(planOptional.isPresent()) {
			this.planRepo.delete(planOptional.get());
		}
		else {
			System.out.println("Plan is Not Present");
		}

	}

}
