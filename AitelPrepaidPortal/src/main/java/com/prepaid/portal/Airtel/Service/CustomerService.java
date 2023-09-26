package com.prepaid.portal.Airtel.Service;

import java.util.List;

import com.prepaid.portal.Airtel.Model.AddOn;
import com.prepaid.portal.Airtel.Model.Customer;


public interface CustomerService {
	

	Customer createCustomer(Customer customer);
	
	List<Customer> getAllCustomer();
	
	Customer updateCustomer(Long customerId, Customer updateCustomer);
	
	void deleteCustomer(Long customerId);
	
	Customer selectPlanByName(Long customerId, String planName);
	
	Customer selectPlanById(Long customerId, Long planId);
	
	Customer addAddOn(Long customerId, AddOn addOn);
	
	Customer removeAddOn(Long cutomerId, AddOn addOn);
}
