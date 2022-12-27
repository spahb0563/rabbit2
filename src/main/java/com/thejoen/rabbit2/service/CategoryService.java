package com.thejoen.rabbit2.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thejoen.rabbit2.model.network.dto.category.CategoryListResponseDTO;
import com.thejoen.rabbit2.repository.CategoryRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class CategoryService {
	
	private final CategoryRepository categoryRepository;
	
	@Transactional(readOnly = true)
	public ResponseEntity<List<CategoryListResponseDTO>> readAll() {
		List<CategoryListResponseDTO> categoryListResponseDTOs = 
				categoryRepository.findAll().stream()
				.map(category -> new CategoryListResponseDTO(category))
				.collect(Collectors.toList());
		
		return ResponseEntity.ok(categoryListResponseDTOs);
	}
}
