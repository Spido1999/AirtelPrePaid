package com.prepaid.portal.Airtel.Repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.prepaid.portal.Airtel.Model.Plan;

@Repository
public interface PlanRepo extends JpaRepository<Plan, Long> {
	
	Optional<Plan> findByPlanName(String planName);
	
//	Plan findByPlanName(String planName);

}
