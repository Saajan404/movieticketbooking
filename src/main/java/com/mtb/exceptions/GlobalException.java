package com.mtb.exceptions;

import java.util.Date;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;



@ControllerAdvice
public class GlobalException {
	
	    // handler method for handling specific exception
    	 @ExceptionHandler(ResourceNotFoundException.class)
		public ResponseEntity<?> resourceNotFoundHandling(ResourceNotFoundException ex, WebRequest request)
		{

			ErrorDetails errors = new ErrorDetails(new Date(),
					ex.getMessage(), request.getDescription(false));
			return new ResponseEntity<>(errors, HttpStatus.NOT_FOUND);

		}
		
    	//method for handling duplicate value
    		@ExceptionHandler(DataIntegrityViolationException.class)
    		public ResponseEntity<?> HandleDataIntegerityViolation(DataIntegrityViolationException ex, WebRequest request)
    		{

    			ErrorDetails errors1 = new ErrorDetails(new Date(),
    					ex.getMessage(), request.getDescription(false));
    			return new ResponseEntity<>(errors1, HttpStatus.BAD_REQUEST);

    		}
		
		   @ExceptionHandler(MoreSeatNotAvailavleException.class)
			public ResponseEntity<?> seatNotAvailableExcpetion(MoreSeatNotAvailavleException ex, WebRequest request)
			{
			   
			   
			   ErrorDetails errors = new ErrorDetails(new Date(),
						ex.getMessage(), request.getDescription(false));
				return new ResponseEntity<>(errors, HttpStatus.NOT_FOUND);

			   
			   
					
			}

}
