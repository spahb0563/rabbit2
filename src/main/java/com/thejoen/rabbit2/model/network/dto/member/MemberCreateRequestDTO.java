package com.thejoen.rabbit2.model.network.dto.member;

import com.thejoen.rabbit2.model.entity.Member;
import com.thejoen.rabbit2.model.enumclass.MemberRole;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class MemberCreateRequestDTO {
	
	private String email;
	
	private String password;
	
	private String nickname;
	
	private String address;
	
	@Builder
	public MemberCreateRequestDTO(String email, String password, String nickname, String address) {
		this.email = email;
		this.password = password;
		this.nickname = nickname;
		this.address = address;
	}
	
	public Member toEntitiy(String password) {
		return Member.builder()
				.email(email)
				.password(password)
				.nickname(nickname)
				.role(MemberRole.ROLE_USER)
				.build()
				;
	}	
}
