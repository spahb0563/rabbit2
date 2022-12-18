package com.thejoen.rabbit2.model.network.dto.item;

import java.math.BigDecimal;

import com.thejoen.rabbit2.model.entity.Category;
import com.thejoen.rabbit2.model.entity.Item;
import com.thejoen.rabbit2.model.entity.Member;

import lombok.Builder;
import lombok.Getter;

@Getter
public class ItemRequestDTO {
    
	private String title;
	
	private String content;
	
	private BigDecimal price;
	
	private Long sellerId;
	
	private Long categoryId;

	@Builder
	public ItemRequestDTO(String title, String content, BigDecimal price, Long sellerId, Long categoryId) {
		this.title = title;
		this.content = content;
		this.price = price;
		this.sellerId = sellerId;
		this.categoryId = categoryId;
	}
	
	public Item toEntitiy(Member seller, Category category) {
		return Item.builder()
				.title(title)
				.content(content)
				.price(price)
				.category(category)
				.seller(seller)
				.build()
				;
	}
	
	
}
