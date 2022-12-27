package com.thejoen.rabbit2.controller.api;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.thejoen.rabbit2.model.network.dto.category.CategoryListResponseDTO;
import com.thejoen.rabbit2.service.CategoryService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("api/v1")
public class CategoryApiController {

	private final CategoryService categoryService;
	
	@GetMapping("/category")
	public ResponseEntity<List<CategoryListResponseDTO>> readAll() {
		return categoryService.readAll();
	}
}
