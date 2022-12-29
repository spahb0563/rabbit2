package com.thejoen.rabbit2.repository;

import java.math.BigInteger;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import com.querydsl.core.types.Projections;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import com.thejoen.rabbit2.model.entity.Item;
import com.thejoen.rabbit2.model.entity.QCategory;
import com.thejoen.rabbit2.model.entity.QItem;
import com.thejoen.rabbit2.model.entity.QMember;
import com.thejoen.rabbit2.model.entity.QRegion;
import com.thejoen.rabbit2.model.enumclass.ItemStatus;
import com.thejoen.rabbit2.model.network.dto.item.ItemListResponseDTO;

import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class ItemRepositoryImpl implements ItemRepositoryCustom{
	
	private final JPAQueryFactory queryFactory;
	private QItem item = QItem.item;
	private QMember member = QMember.member;
	private QCategory category = QCategory.category;
	private QRegion region = QRegion.region;
	
	@Override
	public Page<ItemListResponseDTO> findAllBySellerId(Long sellerId, Pageable pageable) {
		List<ItemListResponseDTO> content = queryFactory
				.select(Projections.constructor(ItemListResponseDTO.class,
						item.id, item.title,
						item.price, item.status,
						item.viewCount, item.likeCount,
						item.region.city, item.region.town,
						item.updatedAt))
				.from(item)
				.join(item.region, region)
				.where(item.seller.id.eq(sellerId))
				.orderBy(item.id.desc())
				.offset(pageable.getOffset())
				.limit(pageable.getPageSize())
				.fetch(); 
		return new PageImpl<>(content, pageable, content.size());
	}
	
	@Override
	public Page<ItemListResponseDTO> findAllByBuyerId(Long buyerId, Pageable pageable) {
		List<ItemListResponseDTO> content = queryFactory
				.select(Projections.constructor(ItemListResponseDTO.class,
						item.id, item.title,
						item.price, item.status,
						item.viewCount, item.likeCount,
						item.region.city, item.region.town,
						item.updatedAt))
				.from(item)
				.join(item.region, region)
				.where(item.buyer.id.eq(buyerId))
				.orderBy(item.id.desc())
				.offset(pageable.getOffset())
				.limit(pageable.getPageSize())
				.fetch(); 
		
		return new PageImpl<>(content, pageable, content.size());
	}
	
	
	@Override
	public Page<ItemListResponseDTO> search(String title, BigInteger minPrice, BigInteger maxPrice, ItemStatus status, List<Long> categoryId, Pageable pageable) {
		List<ItemListResponseDTO> content = queryFactory
				.select(Projections.constructor(ItemListResponseDTO.class,
						item.id, item.title,
						item.price, item.status,
						item.viewCount, item.likeCount,
						item.region.city, item.region.town,
						item.updatedAt))
				.from(item)
				.join(item.category, category)
				.join(item.region, region)
				.where(
						titleContations(title),
						priceGoe(minPrice),
						priceLoe(maxPrice),
						statusEq(status),
						categoryIn(categoryId))
				.offset(pageable.getOffset())
				.limit(pageable.getPageSize())
				.fetch(); 
		
		return new PageImpl<>(content, pageable, content.size());
	}
	
	private BooleanExpression titleContations(String title) {
		
		return StringUtils.isNotBlank(title) ? item.title.contains(title) : null;
	}

	private BooleanExpression priceGoe(BigInteger minPrice) {
		
		return minPrice != null ? item.price.goe(minPrice) : null;
	}
	
	private BooleanExpression priceLoe(BigInteger maxPrice) {
		
		return maxPrice != null ? item.price.loe(maxPrice) : null;
	}
	
	private BooleanExpression statusEq(ItemStatus status) {
		
		return status != null ? item.status.eq(status) : null;
	}
	
	private BooleanExpression categoryIn(List<Long> categoryId) {
		
		return categoryId != null ? item.category.id.in(categoryId) : null;
	}
}
