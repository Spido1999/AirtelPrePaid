package com.prepaid.portal.Airtel.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prepaid.portal.Airtel.Model.AddOn;
import com.prepaid.portal.Airtel.Model.Customer;
import com.prepaid.portal.Airtel.Model.Plan;
import com.prepaid.portal.Airtel.Repo.CustomerRepo;
import com.prepaid.portal.Airtel.Repo.PlanRepo;


@Service
public class CustomerServiceImpl implements CustomerService {
	
	
	@Autowired
	private CustomerRepo customerRepo;
	
	@Autowired
	private PlanRepo planRepo;
	
	@Autowired
	private PlanService planService;

	@Override
	public Customer createCustomer(Customer customer) {
		Customer Create=new Customer(customer.getCustomerName(), customer.getSelectedPlan(), customer.getSelectedAddons());
		
		return this.customerRepo.save(Create);
	}

	@Override
	public List<Customer> getAllCustomer() {
		
		return this.customerRepo.findAll();
	}

	@Override
	public Customer updateCustomer(Long customerId, Customer updateCustomer) {
		Optional<Customer> custOptional=this.customerRepo.findById(customerId);
		if(custOptional.isPresent()) {
			Customer obj=custOptional.get();
			obj.setCustomerName(updateCustomer.getCustomerName());
//			obj.setSelectedAddons(updateCustomer.getSelectedAddons());
//			obj.setSelectedPlan(updateCustomer.getSelectedPlan());
			Customer update=this.customerRepo.save(obj);
			
			return update;
		}
		else {
			return null;
		}
	}

	@Override
	public void deleteCustomer(Long customerId) {
		Optional<Customer> custOptional=this.customerRepo.findById(customerId);
		
		if(custOptional.isPresent()) {
			this.customerRepo.delete(custOptional.get());
		}
		else {
			System.out.println("Not Exist");
		}
	}

//	@Override
//	public Customer selectPlan(Long customerId, plan plans) {
//		Optional<Customer> custOptional=this.customerRepo.findById(customerId);
//		if(custOptional.isPresent()) {
//			Customer obj =custOptional.get();
//			
//			obj.setSelectedPlan(plans);
//			
//			Customer selplan=this.customerRepo.save(obj);
//			
//			return selplan;
//		}
//		
//		else {
//			return null;
//		}
//	}
	
	

	@Override
	public Customer addAddOn(Long customerId, AddOn addOn) {
		Optional<Customer> custOptional=this.customerRepo.findById(customerId);
		if(custOptional.isPresent()) {
			Customer obj=custOptional.get();
			Set<AddOn> seleAddOns=obj.getSelectedAddons();
			seleAddOns.add(addOn);
			obj.setSelectedAddons(seleAddOns);
			Customer addOnSa=this.customerRepo.save(obj);
			
			return addOnSa;
		}
		
		else
		{
			return null;
		}
	}

	public Customer removeAddOn(Long customerId, AddOn addOn) {
	    Optional<Customer> custOptional = this.customerRepo.findById(customerId);
	    if (custOptional.isPresent()) {
	        Customer obj = custOptional.get();
	        Set<AddOn> selectedAddons = obj.getSelectedAddons();
	     
	        Optional<AddOn> addOnToRemove = selectedAddons.stream()
	                .filter(a -> a.getAddOnId().equals(addOn.getAddOnId()))
	                .findFirst();

	        if (addOnToRemove.isPresent()) {
	            selectedAddons.remove(addOnToRemove.get());
	            obj.setSelectedAddons(selectedAddons);
	            Customer addOnRemove = this.customerRepo.save(obj);
	            return addOnRemove;
	        }
	    }
	    
	    return null;
	}

	@Override
	public Customer selectPlanByName(Long customerId, String planName) {
		
		 Optional<Customer> custOptional = customerRepo.findById(customerId);
		    if (custOptional.isPresent()) {
		        Customer obj = custOptional.get();
		        Plan selectedPlan = planService.getByPlanName(planName);
		        if (selectedPlan != null) {
		            obj.setSelectedPlan(selectedPlan);
		            Customer selplan = customerRepo.save(obj);
		            return selplan;
		        }
		    }
		    return null;
	}

	@Override
	public Customer selectPlanById(Long customerId, Long planId) {
		Optional<Customer> custOptional = customerRepo.findById(customerId);
	    if (custOptional.isPresent()) {
	        Customer obj = custOptional.get();
	        Plan selectedPlan = planService.getByPlanName(null);
	        if (selectedPlan != null) {
	            obj.setSelectedPlan(selectedPlan);
	            Customer selplan = customerRepo.save(obj);
	            return selplan;
	        }
	    }
	    return null;
	}

}
