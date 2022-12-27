package com.thejoen.rabbit2.model.network.dto.member;

import com.thejoen.rabbit2.model.entity.Member;

import lombok.Getter;

@Getter
public class MemberResponseDTO {
	
	private Long id;
	
	private String email;
	
	private String nickname;
	
	public MemberResponseDTO(Member member) {
		this.id = member.getId();
		this.email = member.getEmail();
		this.nickname = member.getNickname();
	}
}
