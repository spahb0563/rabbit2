package com.thejoen.rabbit2.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import groovy.util.logging.Slf4j;

@Slf4j
@ControllerAdvice
public class ExceptionController {
	
	@ResponseBody
	@ExceptionHandler(BaseException.class)
	public ResponseEntity<ErrorResponse> baseException(BaseException e) {
		
		ErrorResponse errorResponse = ErrorResponse.builder()
				.httpStatus(e.getStatusCode())
				.message(e.getMessage())
				.build()
				;
		
		return ResponseEntity.status(e.getStatusCode()).body(errorResponse);
	}
}
