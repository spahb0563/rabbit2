package com.thejoen.rabbit2.controller.page;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.thejoen.rabbit2.model.network.dto.member.MemberCreateRequestDTO;
import com.thejoen.rabbit2.service.MemberService;

import groovyjarjarpicocli.CommandLine.Model;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RequestMapping("/member")
@Controller
public class MemberContorller {
	
	private final MemberService memberService;
	
	@GetMapping("/my-info")
	public String info(Model model) {
		
		return "my-info";
	}
	
	@GetMapping("/sales-item")
	public String salesItem(Model model) {
		
		
		return "sales-item";
	}
	
	@GetMapping("/purchased-item")
	public String purchasedItem(Model model) {
		
		
		return "purchased-item";
	}
	
	
	
	
	
}
