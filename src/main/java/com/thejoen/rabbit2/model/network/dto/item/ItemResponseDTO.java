package com.thejoen.rabbit2.model.network.dto.item;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import com.thejoen.rabbit2.model.entity.Category;
import com.thejoen.rabbit2.model.entity.Item;
import com.thejoen.rabbit2.model.enumclass.ItemStatus;
import com.thejoen.rabbit2.model.network.dto.category.CategoryResponseDTO;
import com.thejoen.rabbit2.model.network.dto.member.MemberResponseDTO;

import lombok.Getter;

@Getter
public class ItemResponseDTO {
	
	private Long id;
	
	private String title;
	
	private String content;
	
	private BigDecimal price;
	
	private ItemStatus status;
	
	private int view_count;
	
	private int like_count;
	
	private MemberResponseDTO member;
	
	private CategoryResponseDTO category;
	
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
		this.createdAt = item.getCreatedAt();
		this.updatedAt = item.getUpdatedAt();
		this.member = new MemberResponseDTO(item.getSeller());
		this.category = new CategoryResponseDTO(item.getCategory());
	}
}
