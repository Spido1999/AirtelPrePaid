package com.prepaid.portal.Airtel.Controller;

import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.prepaid.portal.Airtel.Model.AddOn;
import com.prepaid.portal.Airtel.Model.Customer;
import com.prepaid.portal.Airtel.Service.CustomerService;


@RestController
@RequestMapping("/api")
public class CustomerController {
	

	private final CustomerService customerService;
	
	public CustomerController(CustomerService customerService) {
		this.customerService=customerService;
	}
	
	@GetMapping("/getAllCustomer")
	public List<Customer> getAllCustomersHandler(){
		return customerService.getAllCustomer();
	}
	
	@PostMapping("/createCustomer")
	public ResponseEntity<?> createCutomerHandler(@RequestBody Customer customer){
		Customer create=this.customerService.createCustomer(customer);
		return new ResponseEntity<>(create, HttpStatus.CREATED);
	}
	
	@PutMapping("/update/{customerId}")
	public ResponseEntity<?> updateCustomerHandler(@PathVariable Long customerId, @RequestBody Customer customer){
		Customer update=this.customerService.updateCustomer(customerId, customer);
		return new ResponseEntity<>(update, HttpStatus.CREATED);
	}
	
	@DeleteMapping("/delete/{customerId}")
	public ResponseEntity<?> deletCustomerHandler(@PathVariable Long customerId){
		try {
            customerService.deleteCustomer(customerId);;
            return ResponseEntity.ok("Customer deleted successfully");
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
		
	}
	
	@PostMapping("/{customerId}/select-plan")
	public ResponseEntity<?> selectPlanHandler(@PathVariable Long customerId, @RequestBody Map<String, Object> requestBody) {
	    String planName = (String) requestBody.get("planName");
	    Long planId = (Long) requestBody.get("planId");

	    if (planName != null) {
	        // Handle planName case
	        Customer select = customerService.selectPlanByName(customerId, planName);
	        if (select != null) {
	            return new ResponseEntity<>(select, HttpStatus.OK);
	        }
	    } else if (planId != null) {
	        // Handle planId case
	        Customer select = customerService.selectPlanById(customerId, planId);
	        if (select != null) {
	            return new ResponseEntity<>(select, HttpStatus.OK);
	        }
	    }

	    return ResponseEntity.notFound().build();
	}


	
	@PostMapping("/{customerId}/add-addOn")
	public ResponseEntity<?> addAddOnHandler(@PathVariable Long customerId, @RequestBody AddOn addOn){
		Customer select=this.customerService.addAddOn(customerId, addOn);
		return new ResponseEntity<>(select, HttpStatus.OK);
	}
	
	@PostMapping("/{customerId}/remove-addon")
	public ResponseEntity<?> removeAddOnHadler(@PathVariable Long customerId, @RequestBody AddOn addOn){
		Customer remove= this.customerService.removeAddOn(customerId, addOn);
		return new ResponseEntity<>(remove, HttpStatus.OK);

		
	}

}
