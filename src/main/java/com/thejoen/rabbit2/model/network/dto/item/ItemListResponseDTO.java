package com.thejoen.rabbit2.model.network.dto.item;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import com.thejoen.rabbit2.model.entity.Item;
import com.thejoen.rabbit2.model.enumclass.ItemStatus;
import com.thejoen.rabbit2.model.network.dto.member.MemberResponseDTO;

import lombok.Getter;

@Getter
public class ItemListResponseDTO {
private Long id;
	
	private String title;
	
	private String content;
	
	private BigDecimal price;
	
	private ItemStatus status;
	
	private int viewCount;
	
	private int likeCount;
	
	private MemberResponseDTO seller;
	
	private LocalDateTime updatedAt;
	
	public ItemListResponseDTO(Item item) {
		this.id = item.getId();
		this.title = item.getTitle();
		this.price = item.getPrice();
		this.status = item.getStatus();
		this.viewCount = item.getViewCount();
		this.likeCount = item.getLikeCount();
		this.updatedAt = item.getUpdatedAt();
		this.seller = new MemberResponseDTO(item.getSeller());
	}
}
