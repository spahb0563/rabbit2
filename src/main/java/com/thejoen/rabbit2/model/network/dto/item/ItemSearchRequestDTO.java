package com.thejoen.rabbit2.model.network.dto.item;

import java.math.BigInteger;
import java.util.List;

import com.thejoen.rabbit2.model.enumclass.ItemStatus;

import lombok.Getter;

@Getter
public class ItemSearchRequestDTO {
	
	private String title;
	
	private BigInteger maxPrice;
	
	private BigInteger minPrice;
	
	private ItemStatus status; 
	
	private List<Long> categoryIdList;
	
	private Long regionId;
}
