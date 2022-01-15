package com.sadhanoday.springbootexamples.customexceptions;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalRestControllerAdviceExceptionHandler {

	@ExceptionHandler(UserNameNotFoundException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public CustomErrorInfo handleUserNotFound(UserNameNotFoundException ex) {
		return new CustomErrorInfo(new Date(), "From RestControllerAdvice", ex.getMessage());
	}
	
}
