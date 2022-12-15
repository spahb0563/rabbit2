package com.thejoen.rabbit2.model.network.dto.item;

import java.time.LocalDateTime;

import com.thejoen.rabbit2.model.entity.Item;

import lombok.Getter;

@Getter
public class ItemResponseDTO {
	private Long id;
	private String title;
	private String content;
	private Integer price;
	private String status;
	private Integer view_count;
	private Integer like_count;
	private LocalDateTime createdAt;
	private LocalDateTime updatedAt;
	
	public ItemResponseDTO(Item item) {
		this.id = item.getId();
		this.title = item.getTitle();
		this.content = item.getContent();
		this.price = item.getPrice();
		this.status = item.getStatus();
		this.view_count = item.getView_count();
		this.like_count = item.getLike_count();
	}
}
