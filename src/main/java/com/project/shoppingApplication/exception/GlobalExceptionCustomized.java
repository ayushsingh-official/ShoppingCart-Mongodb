package com.project.shoppingApplication.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class GlobalExceptionCustomized extends ResponseEntityExceptionHandler{

	// We are handling/customizing ResourceNotFoundException class here.
	@ExceptionHandler(value = ResourceNotFoundException.class)
	public ResponseEntity<?> handleResourceNotFoundException() {

		return new ResponseEntity<>("Data not found/Available", HttpStatus.NOT_FOUND);

	}
}
