package com.prepaid.portal.Airtel.Model;

import java.util.HashSet;
import java.util.Set;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;

@Entity
public class Customer {

	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "customer_sequence")
    @SequenceGenerator(name = "customer_sequence", sequenceName = "customer_sequence", initialValue = 1, allocationSize = 1)
	private Long customerId;
	private String customerName;
	@ManyToOne
    private Plan selectedPlan;
	
	@ManyToMany
    @JoinTable(
            name = "customer_addon_features",
            joinColumns = @JoinColumn(name = "customerId"),
            inverseJoinColumns = @JoinColumn(name = "addonFeatureId")
    )
    private Set<AddOn> selectedAddons = new HashSet<>();

	public Customer( String customerName, Plan selectedPlan, Set<AddOn> selectedAddons) {
		super();
		this.customerName = customerName;
		this.selectedPlan = selectedPlan;
		this.selectedAddons = selectedAddons;
	}

	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public Plan getSelectedPlan() {
		return selectedPlan;
	}

	public void setSelectedPlan(Plan selectedPlan) {
		this.selectedPlan = selectedPlan;
	}

	public Set<AddOn> getSelectedAddons() {
		return selectedAddons;
	}

	public void setSelectedAddons(Set<AddOn> selectedAddons) {
		this.selectedAddons = selectedAddons;
	}

	@Override
	public String toString() {
		return "Customer [customerId=" + customerId + ", customerName=" + customerName + ", selectedPlan="
				+ selectedPlan + ", selectedAddons=" + selectedAddons + "]";
	}
	
	
}
