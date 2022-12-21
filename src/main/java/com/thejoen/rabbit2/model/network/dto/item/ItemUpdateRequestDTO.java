package com.thejoen.rabbit2.model.network.dto.item;

import java.math.BigDecimal;

import com.thejoen.rabbit2.model.enumclass.ItemStatus;

import lombok.Builder;
import lombok.Getter;

@Getter
public class ItemUpdateRequestDTO {
	
	private String title;
	
	private String content;
	
	private BigDecimal price;
			
	private ItemStatus status;
	
	private Long categoryId;
	
	private Long buyerId;

	@Builder
	public ItemUpdateRequestDTO(String title, String content, BigDecimal price, ItemStatus status, Long categoryId, Long buyerId) {
		this.title = title;
		this.content = content;
		this.price = price;
		this.status = status;
		this.categoryId = categoryId;
		this.buyerId = buyerId;
	}
}
