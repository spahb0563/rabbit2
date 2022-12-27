package com.thejoen.rabbit2.model.enumclass;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum MemberRole {
	
	ROLE_USER(0, "USER"),
	ROLE_MANAGER(1, "MANAGER");
	
	private Integer id;
	
	private String title;
	
}
