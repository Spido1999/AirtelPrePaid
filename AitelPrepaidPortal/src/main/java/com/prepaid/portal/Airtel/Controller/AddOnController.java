package com.prepaid.portal.Airtel.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.prepaid.portal.Airtel.Model.AddOn;
import com.prepaid.portal.Airtel.Service.AddOnService;


@RestController
@RequestMapping("/api")
public class AddOnController {
	
	private final AddOnService addOnService;
	
	@Autowired
	public AddOnController(AddOnService addOnService) {
		this.addOnService=addOnService;
	}
	
	
	@GetMapping("/addOn")
	public List<AddOn> getAllAddOn() {
		return addOnService.getAllAddOn();
	}
	
	
	@PostMapping("/addAddOn")
	public ResponseEntity<?> addAddOnHandler(@RequestBody AddOn objAdd){
		
		AddOn addAddOn=this.addOnService.addAddOn(objAdd);
		return new ResponseEntity<>(addAddOn, HttpStatus.CREATED);
	}
	
    @GetMapping("/getAddOn")
    public ResponseEntity<?> getAddOnHandler(
            @RequestParam(required = false) String fetuName,
            @RequestParam(required = false) Long addOnId) {
        if (fetuName != null) {
            AddOn getAddOnByName = this.addOnService.getByAddOnByName(fetuName);
            if (getAddOnByName != null) {
                return new ResponseEntity<>(getAddOnByName, HttpStatus.OK);
            } else {
                return ResponseEntity.notFound().build();
            }
        } else if (addOnId != null) {
            AddOn getAddOnById = this.addOnService.getByAddOnId(addOnId);
            if (getAddOnById != null) {
                return new ResponseEntity<>(getAddOnById, HttpStatus.OK);
            } else {
                return ResponseEntity.notFound().build();
            }
        } else {
            return ResponseEntity.badRequest().body("Invalid request parameters");
        }
    }
    
    
    @PutMapping("/updateAddOn/{addOnId}")
    public ResponseEntity<?> updateAddOnhandler(@PathVariable Long addOnId,@RequestBody AddOn addOn){
    	
    	AddOn updateAddOn=this.addOnService.updateById(addOn, addOnId);
    	if(updateAddOn!=null) {
    		return new ResponseEntity<>(updateAddOn, HttpStatus.CREATED);
    	}
    	else {
            return ResponseEntity.notFound().build();
        }
    	
    }
    
    
    @DeleteMapping("/deleteAddOn/{addOnId}")
    public ResponseEntity<String> deletAddOnHadler(@PathVariable Long addOnId){
    	try {
            addOnService.deleteById(addOnId);
            return ResponseEntity.ok("AddOn deleted successfully");
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }
	

}
