package com.rodrigo.newJournal2.resources.exceptions;

import javax.servlet.http.HttpServlet;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.rodrigo.newJournal2.service.exceptions.ObjectNotFoundException;
import com.rodrigo.newJournal2.service.exceptions.StandardError;

@ControllerAdvice
public class ResourceExceptionHandler {

	@ExceptionHandler(ObjectNotFoundException.class)
	public ResponseEntity<StandardError>objectNotFound(ObjectNotFoundException e, 
			HttpServlet request){
		StandardError error = new StandardError(HttpStatus.NOT_FOUND.value(), 
			e.getMessage(),
			System.currentTimeMillis());
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
	
	}
}