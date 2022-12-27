package com.thejoen.rabbit2.repository;

import java.math.BigDecimal;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import com.thejoen.rabbit2.model.entity.Item;
import com.thejoen.rabbit2.model.entity.QItem;

import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class ItemRepositoryImpl implements ItemRepositoryCustom{
	
	
	private final JPAQueryFactory queryFactory;
	private QItem item = QItem.item;
	
	
	@Override
	public Page<Item> search(String title, BigDecimal minPrice, BigDecimal maxPrice, Pageable pageable) {
		
		
		List<Item> content = queryFactory.selectFrom(item)
				.where(titleContations(title), priceGt(minPrice), priceLt(maxPrice))
				.offset(pageable.getOffset())
				.limit(pageable.getPageSize())
				.fetch()
				; 
		
		return new PageImpl<>(content, pageable, content.size());
				
	}
	
	private BooleanExpression titleContations(String title) {
		
		return StringUtils.isNotBlank(title) ? item.title.contains(title) : null;
	}

	private BooleanExpression priceGt(BigDecimal minPrice) {
		
		return minPrice != null ? item.price.gt(minPrice) : null;
	}
	
	private BooleanExpression priceLt(BigDecimal maxPrice) {
		
		return maxPrice != null ? item.price.lt(maxPrice) : null;
	}
}
