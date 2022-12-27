package com.thejoen.rabbit2.controller.page;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.thejoen.rabbit2.model.network.dto.category.CategoryListResponseDTO;
import com.thejoen.rabbit2.service.CategoryService;

import lombok.RequiredArgsConstructor;


@RequiredArgsConstructor
@RequestMapping("/item")
@Controller
public class ItemController {

	private final CategoryService categoryService;
	
	@GetMapping("/write")
	public String write(Model model) {
		
		List<CategoryListResponseDTO> categoryList = categoryService.readAll().getBody();
		
		model.addAttribute("categoryList", categoryList);
		
		return "write";
	}

	
	
}
