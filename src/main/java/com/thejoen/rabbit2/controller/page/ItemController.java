package com.thejoen.rabbit2.controller.page;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.thejoen.rabbit2.model.network.dto.category.CategoryListResponseDTO;
import com.thejoen.rabbit2.model.network.dto.item.ItemResponseDTO;
import com.thejoen.rabbit2.service.CategoryService;
import com.thejoen.rabbit2.service.ItemService;

import lombok.RequiredArgsConstructor;


@RequiredArgsConstructor
@RequestMapping("/item")
@Controller
public class ItemController {

	private final ItemService itemService;
	
	private final CategoryService categoryService;
	
	@GetMapping("/{id}")
	public String detail(@PathVariable Long id, Model model) {
		
		ItemResponseDTO item = itemService.read(id).getBody();
		
		model.addAttribute("item", item);
		
		return "/item/item-detail";
		
	}
	
	@GetMapping("/write")
	public String write(Model model) {
		
		List<CategoryListResponseDTO> categoryList = categoryService.readAll().getBody();
		
		model.addAttribute("categoryList", categoryList);
		
		return "/item/item-write";
	}
}
