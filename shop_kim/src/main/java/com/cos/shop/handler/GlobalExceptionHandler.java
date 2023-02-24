package com.cos.shop.handler;

import java.sql.SQLIntegrityConstraintViolationException;

import org.hibernate.exception.ConstraintViolationException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.transaction.TransactionSystemException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

import com.cos.shop.dto.ResponseDto;



@ControllerAdvice
@RestController
public class GlobalExceptionHandler {

	@ExceptionHandler(value=Exception.class)
	public ResponseDto<String> handleArgumentException(Exception e) {
		return new ResponseDto<String>(HttpStatus.INTERNAL_SERVER_ERROR.value(),e.getMessage());
	}
	@ExceptionHandler(DataIntegrityViolationException.class)
	public ResponseDto<String> constraintException(DataIntegrityViolationException ex) {
	    return new ResponseDto<String>(HttpStatus.INTERNAL_SERVER_ERROR.value(),"Username has been already used. Please use other username");
	    		
	}
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseDto<String> processValidationError(MethodArgumentNotValidException ex) {
	    return new ResponseDto<String>(HttpStatus.INTERNAL_SERVER_ERROR.value(),ex.getBindingResult().getAllErrors().get(0).getDefaultMessage());
	    		
	}
	@ExceptionHandler(ConstraintViolationException.class)
	public ResponseDto<String> constraintError(ConstraintViolationException ex) {
	    return new ResponseDto<String>(HttpStatus.INTERNAL_SERVER_ERROR.value(),ex.getMessage());
	    		
	}
	
}
