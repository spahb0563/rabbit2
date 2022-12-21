package com.thejoen.rabbit2.exception;

import org.springframework.http.HttpStatus;

public class RegionNotFoundException extends BaseException{
	
	private static final String MESSAGE = "존재하지 않는 지역입니다.";
	
	public RegionNotFoundException() {
		super(MESSAGE);
	}

	@Override
	public HttpStatus getStatusCode() {
		return HttpStatus.NOT_FOUND;
	}
	
}
