package com.thejoen.rabbit2.model.network.dto.member;

import lombok.Builder;
import lombok.Getter;

@Getter
public class MemberUpdateRequestDTO {
	
	private String password;
	
	private String nickname;
	
	private String picture;
	
	@Builder
	public MemberUpdateRequestDTO(String password, String nickname, String picture) {
		this.password = password;
		this.nickname = nickname;
		this.picture = picture;
	}
}
