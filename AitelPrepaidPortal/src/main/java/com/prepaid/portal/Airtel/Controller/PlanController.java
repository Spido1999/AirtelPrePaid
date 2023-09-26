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

import com.prepaid.portal.Airtel.Exception.DuplicatePlanNameException;
import com.prepaid.portal.Airtel.Exception.IncompletePlanDataException;
import com.prepaid.portal.Airtel.Model.Plan;
import com.prepaid.portal.Airtel.Service.PlanService;



@RestController
@RequestMapping("/api")
public class PlanController {
	
	private final PlanService planService;

    @Autowired
    public PlanController(PlanService planService) {
        this.planService = planService;
    }
    
    
    @GetMapping("/plans")
    public List<Plan> getAllPlans() {
        return planService.getAllPlan();
    }
    @PostMapping("/Craete")
    public ResponseEntity<?> createPlanHandler(@RequestBody Plan planObj) {
        try {
            Plan newPlan = this.planService.createPlan(planObj);
            return new ResponseEntity<>(newPlan, HttpStatus.CREATED);
        } catch (DuplicatePlanNameException e) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Plan name already exists.");
        } catch (IncompletePlanDataException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Plan data is incomplete. All fields (planName, planCost, planDetails) are required.");
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An error occurred while creating the plan.");
        }
    }


    
    @GetMapping("/getPlan")
    public ResponseEntity<?> getPlanHandler(
            @RequestParam(required = false) String planName,
            @RequestParam(required = false) Long planId) {
        if (planName != null) {
            Plan getPlanByName = this.planService.getByPlanName(planName);
            if (getPlanByName != null) {
                return new ResponseEntity<>(getPlanByName, HttpStatus.OK);
            } else {
                return ResponseEntity.notFound().build();
            }
        } else if (planId != null) {
            Plan getById = this.planService.getByPlanId(planId);
            if (getById != null) {
                return new ResponseEntity<>(getById, HttpStatus.OK);
            } else {
                return ResponseEntity.notFound().build();
            }
        } else {
            return ResponseEntity.badRequest().body("Invalid request parameters");
        }
    }
    
    @PutMapping("/updatePlan/{planId}")
    public ResponseEntity<?> updatePlanHandler(@PathVariable Long planId, @RequestBody Plan updatePlan){
        Plan updatedPlan = this.planService.updateById(updatePlan, planId);
        if (updatedPlan != null) {
            return new ResponseEntity<>(updatedPlan, HttpStatus.CREATED);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    
    
    @DeleteMapping("/deletePlan/{planId}")
    public ResponseEntity<String> deletPlanHadler(@PathVariable Long planId){
    	try {
            planService.deleteById(planId);
            return ResponseEntity.ok("Plan deleted successfully");
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }
}
