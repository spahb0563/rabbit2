package com.thejoen.rabbit2.model.network.dto.category;

import com.thejoen.rabbit2.model.entity.Category;

import lombok.Getter;

@Getter
public class CategoryResponseDTO {
	
	private Long id;
	
	private String title;
	
	public CategoryResponseDTO(Category category) {
		this.id = category.getId();
		this.title = category.getCategoryType().getTitle();
	}
}
