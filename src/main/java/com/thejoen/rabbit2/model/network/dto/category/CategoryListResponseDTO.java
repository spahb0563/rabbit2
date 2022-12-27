package com.thejoen.rabbit2.model.network.dto.category;

import com.thejoen.rabbit2.model.entity.Category;

import lombok.Getter;

@Getter
public class CategoryListResponseDTO {
	
	private Long id;
	
	private String title;
	
	public CategoryListResponseDTO(Category category) {
		this.id = category.getId();
		this.title = category.getCategoryType().getTitle();
	}
}
