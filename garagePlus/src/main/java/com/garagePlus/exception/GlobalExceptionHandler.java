package com.garagePlus.exception;

import java.time.LocalDate;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class GlobalExceptionHandler {
	
	
	@ExceptionHandler(CustomerException.class)
	public ResponseEntity<MyErrorDetails> customerExeHandler(CustomerException c,WebRequest we){
		MyErrorDetails me = new MyErrorDetails();
		me.setName(c.getMessage());
		me.setDesc(we.getDescription(false));
		me.setTimeStamp(LocalDate.now());
		
		return new ResponseEntity<MyErrorDetails>(me,HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(OrderException.class)
	public ResponseEntity<MyErrorDetails> orderExeHandler(OrderException c,WebRequest we){
		MyErrorDetails me = new MyErrorDetails();
		me.setName(c.getMessage());
		me.setDesc(we.getDescription(false));
		me.setTimeStamp(LocalDate.now());
		
		return new ResponseEntity<MyErrorDetails>(me,HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(Exception.class)
	public ResponseEntity<MyErrorDetails> globalExeHandler(Exception c,WebRequest we){
		MyErrorDetails me = new MyErrorDetails();
		me.setName(c.getMessage());
		me.setDesc(we.getDescription(false));
		me.setTimeStamp(LocalDate.now());
		
		return new ResponseEntity<MyErrorDetails>(me,HttpStatus.BAD_REQUEST);
	}
}
