package com.thejoen.rabbit2.exception;

import org.springframework.http.HttpStatus;

public class CategoryNotFoundException extends BaseException{
	
	private static final String MESSAGE = "존재하지 않는 카테고리입니다.";
	
	public CategoryNotFoundException() {
		super(MESSAGE);
	}

	@Override
	public HttpStatus getStatusCode() {
		return HttpStatus.NOT_FOUND;
	} 

}
