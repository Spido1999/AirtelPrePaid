package com.prepaid.portal.Airtel.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;

public class GlobalExceptionHandler {
	

    @ExceptionHandler(DuplicatePlanNameException.class)
    public ResponseEntity<String> handleDuplicatePlanNameException(DuplicatePlanNameException ex) {
        return ResponseEntity.status(HttpStatus.CONFLICT).body(ex.getMessage());
    }

    @ExceptionHandler(IncompletePlanDataException.class)
    public ResponseEntity<String> handleIncompletePlanDataException(IncompletePlanDataException ex) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
    }


}
