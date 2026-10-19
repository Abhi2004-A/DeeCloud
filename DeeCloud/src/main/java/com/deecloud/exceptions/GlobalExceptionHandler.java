package com.deecloud.exceptions;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.deecloud.response.APIResponse;

@RestControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(exception = AppException.class)
	public ResponseEntity<?> exceptionHandler(AppException exception){
		return new ResponseEntity<>(new APIResponse<>(exception.getMessage(),null,exception.gethttpStatus()),exception.gethttpStatus());
	}

}
