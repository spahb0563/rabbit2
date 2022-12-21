package com.thejoen.rabbit2.model.network.dto.member;

import com.thejoen.rabbit2.model.entity.Member;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class MemberCreateRequestDTO {
	
	private String email;
	
	private String password;
	
	private String nickname;
	
	private Long regionId;
	
	@Builder
	public MemberCreateRequestDTO(String email, String password, String nickname, String name, Long regionId) {
		this.email = email;
		this.password = password;
		this.nickname = nickname;
		this.regionId = regionId;
	}
	
	public Member toEntitiy() {
		return Member.builder()
				.email(email)
				.password(password)
				.nickname(nickname)
				.build()
				;
	}	
}
