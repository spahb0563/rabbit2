package com.thejoen.rabbit2.exception;

import org.springframework.http.HttpStatus;

import lombok.Builder;
import lombok.Getter;

@Getter
public class ErrorResponse {
	
	private final HttpStatus httpStatus;
	
	private final int code;
	
	private final String message;

	@Builder
	public ErrorResponse(HttpStatus httpStatus, String message) {
		this.httpStatus = httpStatus;
		this.code = httpStatus.value();
		this.message = message;
	}
}
