package com.thejoen.rabbit2.model.network.dto.item;

import java.math.BigInteger;
import java.time.LocalDateTime;

import com.thejoen.rabbit2.model.entity.Item;
import com.thejoen.rabbit2.model.enumclass.ItemStatus;
import com.thejoen.rabbit2.model.network.Time;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class ItemListResponseDTO {
	private Long id;
	
	private String title;
	
	private BigInteger price;
	
	private ItemStatus status;
	
	private int viewCount;
	
	private int likeCount;
	
	private String city;
	
	private String town;
	
	private String updatedAt;
	
	public ItemListResponseDTO(Item item) {
		this.id = item.getId();
		this.title = item.getTitle();
		this.price = item.getPrice();
		this.status = item.getStatus();
		this.viewCount = item.getViewCount();
		this.likeCount = item.getLikeCount();
		this.updatedAt = Time.convertLocalDateTimeToTime(item.getUpdatedAt());
	}

	public ItemListResponseDTO(Long id, String title, BigInteger price, ItemStatus status, int viewCount, int likeCount,
			String city, String town, LocalDateTime updatedAt) {
		this.id = id;
		this.title = title;
		this.price = price;
		this.status = status;
		this.viewCount = viewCount;
		this.likeCount = likeCount;
		this.town = city + " " + town;
		this.updatedAt = Time.convertLocalDateTimeToTime(updatedAt);
	}
}
