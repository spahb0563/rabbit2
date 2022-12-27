package com.thejoen.rabbit2.controller.api;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.thejoen.rabbit2.model.network.dto.member.MemberCreateRequestDTO;
import com.thejoen.rabbit2.model.network.dto.member.MemberResponseDTO;
import com.thejoen.rabbit2.model.network.dto.member.MemberUpdateRequestDTO;
import com.thejoen.rabbit2.service.MemberService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor  
@RestController  
@RequestMapping("/api")
public class MemberApiController {
	
	private final MemberService memberService;
	
	@GetMapping("/v1/member/{id}")
	public ResponseEntity<MemberResponseDTO> read(@PathVariable Long id) {
		return memberService.read(id);
	}
	
	@PostMapping("/v1/member")
	public ResponseEntity<MemberResponseDTO> create(@RequestBody MemberCreateRequestDTO request) {
		return memberService.create(request);
	}

	@PutMapping("/v1/member/{id}")
	public ResponseEntity<MemberResponseDTO> update(@PathVariable Long id, @RequestBody MemberUpdateRequestDTO request) {
		return memberService.update(id, request);
	}
	
	@DeleteMapping("/v1/member/{id}")
	public ResponseEntity delete(@PathVariable Long id) {
		return memberService.delete(id);
	}
	
}
