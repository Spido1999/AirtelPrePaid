package com.prepaid.portal.Airtel.Model;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Plan {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long planId;
	private String planName;
	private String planCost; 
	private String planDetails;
	
	
	public Plan( String planName, String planCost, String planDetails) {
		super();
		
		this.planName = planName;
		this.planCost = planCost;
		this.planDetails = planDetails;
	}


	public Plan() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Long getPlanId() {
		return planId;
	}


	public void setPlanId(Long planId) {
		this.planId = planId;
	}


	public String getPlanName() {
		return planName;
	}


	public void setPlanName(String planName) {
		this.planName = planName;
	}


	public String getPlanCost() {
		return planCost;
	}


	public void setPlanCost(String planCost) {
		this.planCost = planCost;
	}


	public String getPlanDetails() {
		return planDetails;
	}


	public void setPlanDetails(String planDetails) {
		this.planDetails = planDetails;
	}


	@Override
	public String toString() {
		return "Plan [planId=" + planId + ", planName=" + planName + ", planCost=" + planCost + ", planDetails="
				+ planDetails + "]";
	}
	
	

}
