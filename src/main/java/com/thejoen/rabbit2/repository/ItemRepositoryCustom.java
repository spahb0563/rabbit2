package com.thejoen.rabbit2.repository;

import java.math.BigInteger;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.thejoen.rabbit2.model.entity.Item;
import com.thejoen.rabbit2.model.enumclass.ItemStatus;
import com.thejoen.rabbit2.model.network.dto.item.ItemListResponseDTO;

public interface ItemRepositoryCustom {
	
	Page<ItemListResponseDTO> findAllBySellerId(Long sellerId, Pageable pageable);
	
	Page<ItemListResponseDTO> findAllByBuyerId(Long buyerId, Pageable pageable);
	
	Page<ItemListResponseDTO> search(String title, BigInteger minPrice, BigInteger maxPrice, ItemStatus status, List<Long> categoryId, Pageable pageable);
}
