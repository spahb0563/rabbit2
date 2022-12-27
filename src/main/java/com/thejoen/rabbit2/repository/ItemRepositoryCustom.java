package com.thejoen.rabbit2.repository;

import java.math.BigDecimal;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.thejoen.rabbit2.model.entity.Item;

public interface ItemRepositoryCustom {
	Page<Item> search(String title, BigDecimal minPrice, BigDecimal maxPrice, Pageable pageable);
	
	
}
