package com.sadhanoday.springbootexamples.customexceptions;

import java.util.Date;

import javax.validation.ConstraintViolationException;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
 
//@ControllerAdvice
public class CustomGlobalExceptionHandler extends ResponseEntityExceptionHandler {

	@Override
	public ResponseEntity<Object> handleMethodArgumentNotValid(
			MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {

		CustomErrorInfo customErrorInfo = new CustomErrorInfo(new Date(), "From MethodArgumentNotValid Exception in GEH", ex.getMessage());

		return new ResponseEntity<Object>(customErrorInfo, HttpStatus.BAD_REQUEST);
	}

	protected ResponseEntity<Object> handleHttpRequestMethodNotSupported(
			HttpRequestMethodNotSupportedException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {

		CustomErrorInfo customErrorInfo = new CustomErrorInfo(new Date(), "From handleHttpRequestMethodNotSupported Exception in GEH.", ex.getMessage());

		return new ResponseEntity<Object>(customErrorInfo, HttpStatus.METHOD_NOT_ALLOWED);

	}
	
	//ResponseEntity is something that is shown on the browser/postman and it consists : timestamp, status, error, message, path. 
	// So when we want to show customized information, we can overwrite methods of ResponseEntityExceptionHandler.
	//For Ex:
	
	/*{
	    "timestamp": "2022-01-13T07:18:01.157+00:00",
	    "status": 500,
	    "error": "Internal Server Error",
	    "message": "Username: 'kreddyqq' not found in User repository",
	    "path": "/users/byusername/kreddyqq"
	}*/

	@ExceptionHandler(UserNameNotFoundException.class) 
	public final ResponseEntity<Object> handleUserNotFoundException(UserNameNotFoundException ex, WebRequest request) {//Generic interface for a web request. Mainly intended for generic web request interceptors, giving them access to general request metadata, not for actual handling of the request.
		CustomErrorInfo customErrorInfo = new CustomErrorInfo(new Date(), ex.getMessage(), request.getDescription(true));
		
		return new ResponseEntity<Object>(customErrorInfo, HttpStatus.NOT_FOUND);
	}
	
	//Handle ConstraintViolationException
	@ExceptionHandler(ConstraintViolationException.class)
	public final ResponseEntity<Object> handleConstraintViolationException(ConstraintViolationException ex, WebRequest request){
		CustomErrorInfo customErrorInfo = new CustomErrorInfo(new Date(), ex.getMessage(), "User Id must be greater than 0");
		
		return new ResponseEntity<Object>(customErrorInfo, HttpStatus.BAD_REQUEST);
	}
	
}
