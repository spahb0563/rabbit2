package com.thejoen.rabbit2.model.network.dto.item;

import java.math.BigInteger;
import java.time.LocalDateTime;

import com.thejoen.rabbit2.model.entity.Item;
import com.thejoen.rabbit2.model.enumclass.ItemStatus;
import com.thejoen.rabbit2.model.network.Time;
import com.thejoen.rabbit2.model.network.dto.category.CategoryResponseDTO;
import com.thejoen.rabbit2.model.network.dto.member.MemberResponseDTO;

import lombok.Getter;

@Getter
public class ItemResponseDTO {
	
	private Long id;
	
	private String title;
	
	private String content;
	
	private BigInteger price;
	
	private ItemStatus status;
	
	private int viewCount;
	
	private int likeCount;
	
	private String town;
	
	private MemberResponseDTO seller;
	
	private CategoryResponseDTO category;
	
	private String updatedAt;
	
	public ItemResponseDTO(Item item) {
		this.id = item.getId();
		this.title = item.getTitle();
		this.content = item.getContent();
		this.price = item.getPrice();
		this.status = item.getStatus();
		this.viewCount = item.getViewCount();
		this.likeCount = item.getLikeCount();
		this.updatedAt = Time.convertLocalDateTimeToTime(item.getUpdatedAt());
		this.town = item.getRegion().getCity() + " " + item.getRegion().getTown();
		this.seller = new MemberResponseDTO(item.getSeller());
		this.category = new CategoryResponseDTO(item.getCategory());
	}
}
