package com.prepaid.portal.Airtel.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.prepaid.portal.Airtel.Model.AddOn;

@Service
public interface AddOnService {
	
	List<AddOn> getAllAddOn();
	
	AddOn addAddOn(AddOn addOn);
	
	AddOn getByAddOnId(Long addOnId);
	
	AddOn getByAddOnByName(String fetuName);
	
	AddOn updateById(AddOn addOn, Long addOnId);
	
	void deleteById(Long addOnId);

}
