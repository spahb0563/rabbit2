package com.thejoen.rabbit2.model.network.dto.item;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import com.thejoen.rabbit2.model.entity.Item;

import lombok.Getter;

@Getter
public class ItemResponseDTO {
	
	private Long id;
	
	private String title;
	
	private String content;
	
	private BigDecimal price;
	
	private int status;
	
	private int view_count;
	
	private int like_count;
	
//	private Long CategoryId;
	
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
//		this.CategoryId = item.getCategory().getId();
	}
}
