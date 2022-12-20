package com.thejoen.rabbit2.exception;

import org.springframework.http.HttpStatus;

import lombok.Getter;

@Getter
public abstract class BaseException extends RuntimeException{
	
	public BaseException(String message) {
		super(message);
	}
	
	public BaseException(String message, Throwable cause) {
		super(message, cause);
	}
	
	public abstract HttpStatus getStatusCode();
}
