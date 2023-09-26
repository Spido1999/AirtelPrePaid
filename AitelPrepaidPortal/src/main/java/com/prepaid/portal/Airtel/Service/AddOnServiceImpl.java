package com.prepaid.portal.Airtel.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prepaid.portal.Airtel.Model.AddOn;
import com.prepaid.portal.Airtel.Repo.AddOnRepo;


@Service
public class AddOnServiceImpl implements AddOnService {

	
	@Autowired
	private AddOnRepo addOnRepo; 

	@Override
	public List<AddOn> getAllAddOn() {
		// TODO Auto-generated method stub
		return addOnRepo.findAll();
	}

	@Override
	public AddOn addAddOn(AddOn addOn) {
		AddOn create = new AddOn(addOn.getFetuName(), addOn.getCost());
	    return this.addOnRepo.save(create);
	}

	@Override
	public AddOn getByAddOnId(Long addOnId) {
		Optional<AddOn> addOptional=this.addOnRepo.findById(addOnId);
		
		AddOn objAdd=null;
		if(addOptional.isPresent()) {
			objAdd=addOptional.get();
		}
		else {
			System.out.println("Not Present");
		}
		return objAdd;
	}

	@Override
	public AddOn getByAddOnByName(String fetuName) {
		Optional<AddOn> addOptional=this.addOnRepo.findByFetuName(fetuName);
		AddOn objAdd=null;
		if(addOptional.isPresent()) {
			objAdd=addOptional.get();
		}
		else {
			System.out.println("Not Present");
		}
		return objAdd;
	}

	@Override
	public AddOn updateById(AddOn addOn, Long addOnId) {
		Optional<AddOn> addOptional=this.addOnRepo.findById(addOnId);
		if(addOptional.isPresent()) {
			AddOn obj=addOptional.get();
			obj.setFetuName(addOn.getFetuName());
			obj.setCost(addOn.getCost());
			
			AddOn add=this.addOnRepo.save(obj);
			return add;
		}
		else {
	    	// Handle the case where the plan with the given ID is not found
	        return null;
	    }
	}

	@Override
	public void deleteById(Long addOnId) {
		Optional<AddOn> addOptional=this.addOnRepo.findById(addOnId);
		if(addOptional.isPresent()) {
			this.addOnRepo.delete(addOptional.get());
		}
		else {
			System.out.println("Not exist");
		}
	}

}
