package com.deecloud.response;

import org.springframework.http.HttpStatus;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class APIResponse <T> {
	
	private String message;
	
	private T data;
	
	private HttpStatus httpStatus;

}
