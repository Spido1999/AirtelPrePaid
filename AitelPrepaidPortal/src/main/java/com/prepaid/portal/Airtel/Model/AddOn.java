package com.prepaid.portal.Airtel.Model;

import java.math.BigDecimal;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class AddOn {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long addOnId;
	private String fetuName;
	private String cost;
	
	
	public AddOn() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public AddOn( String fetuName, String cost) {
		super();
		
		this.fetuName = fetuName;
		this.cost = cost;
	}


	public Long getAddOnId() {
		return addOnId;
	}
	public void setAddOnId(Long addOnId) {
		this.addOnId = addOnId;
	}
	public String getFetuName() {
		return fetuName;
	}
	public void setFetuName(String fetuName) {
		this.fetuName = fetuName;
	}
	public String getCost() {
		return cost;
	}
	public void setCost(String cost) {
		this.cost = cost;
	}


	@Override
	public String toString() {
		return "AddOn [addOnId=" + addOnId + ", fetuName=" + fetuName + ", cost=" + cost + "]";
	}
	



}
