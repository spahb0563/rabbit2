package com.thejoen.rabbit2.model.network.dto.item;

import java.math.BigDecimal;

import com.thejoen.rabbit2.model.entity.Category;
import com.thejoen.rabbit2.model.entity.Item;
import com.thejoen.rabbit2.model.entity.Member;
import com.thejoen.rabbit2.model.entity.Region;
import com.thejoen.rabbit2.model.enumclass.ItemStatus;

import lombok.Builder;
import lombok.Getter;

@Getter
public class ItemCreateRequestDTO {
    
	private String title;
	
	private String content;
	
	private BigDecimal price;
	
	private ItemStatus status; 
	
	private Long sellerId;
	
	private Long categoryId;
	
	private Long regionId;

	@Builder
	public ItemCreateRequestDTO(String title, String content, BigDecimal price, ItemStatus status, Long sellerId, Long categoryId, Long regionId) {
		this.title = title;
		this.content = content;
		this.price = price;
		this.status = status;
		this.sellerId = sellerId;
		this.categoryId = categoryId;
		this.regionId = regionId;
	}
	
	public Item toEntitiy(Member seller, Category category, Region region) {
		return Item.builder()
				.title(title)
				.content(content)
				.price(price)
				.status(status)
				.category(category)
				.seller(seller)
				.region(region)
				.build()
				;
	}
	
	
}
