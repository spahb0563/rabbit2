package com.thejoen.rabbit2.exception;

import org.springframework.http.HttpStatus;

public class ItemNotFoundException extends BaseException{
	
	private static final String MESSAGE = "존재하지 않는 글입니다.";
	
	
	public ItemNotFoundException() {
		super(MESSAGE);
	}

	@Override
	public HttpStatus getStatusCode() {
		return HttpStatus.NOT_FOUND;
	}
	
}
