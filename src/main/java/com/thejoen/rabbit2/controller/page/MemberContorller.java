package com.thejoen.rabbit2.controller.page;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MemberContorller {
	
	@GetMapping("/register")
    public String register() {
        return "register";
    }
}
