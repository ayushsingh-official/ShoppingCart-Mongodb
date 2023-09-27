package com.project.shoppingApplication.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

// Only one class will do all exception.
@Component
public class GlobalExceptionCustomized extends RuntimeException {

	private static final long serialVersionUID = 1L;


	public ResponseEntity<?> resourceNotFoundException() {

		return new ResponseEntity<>("Data not found/Available", HttpStatus.NOT_FOUND);

	}
	
	
	

}
