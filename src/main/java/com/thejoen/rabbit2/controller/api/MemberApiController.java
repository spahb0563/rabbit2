package com.thejoen.rabbit2.controller.api;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.thejoen.rabbit2.service.MemberService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor  
@RestController  
@RequestMapping("/api")
public class MemberApiController {
	
	private final MemberService memberService;
	
//	@GetMapping("/v1/member/{id}")
//	public MemberResponseDTO read(@PathVariable Long id) {
//		
//		return memberService.findById(id);
//		
//	}
//	
//	@PostMapping("/v1/member")
//	public Long create(@RequestBody MemberCreateRequestDTO request) {
//		
//		return memberService.create(memberRequestDTO);
//	}
//
//	@PutMapping("/v1/member/{id}")
//	public Long update(@PathVariable Long id, @RequestBody MemberRequestDTO request) {
//		
//		return memberService.update(id,memberRequestDTO);
//	}
//	
//	@DeleteMapping("/v1/member/{id}")
//	public Long delete(@PathVariable Long id) {
//		
//		return memberService.delete(id);
//		
//	}
	
}
