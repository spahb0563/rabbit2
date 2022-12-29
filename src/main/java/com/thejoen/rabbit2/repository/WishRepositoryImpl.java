package com.thejoen.rabbit2.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import com.querydsl.jpa.impl.JPAQueryFactory;
import com.thejoen.rabbit2.model.entity.Item;
import com.thejoen.rabbit2.model.entity.QItem;
import com.thejoen.rabbit2.model.entity.QMember;
import com.thejoen.rabbit2.model.entity.QWish;
import com.thejoen.rabbit2.model.entity.Wish;

import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class WishRepositoryImpl implements WishRepositoryCustom{
	
	private final JPAQueryFactory queryFactory;
	
	private QWish wish = QWish.wish;
	
	private QMember member = QMember.member;
	
	private QItem item = QItem.item;
	
	@Override
	public Page<Wish> findAllByMemberId(Long memberId, Pageable pageable) {
		List<Wish> content = queryFactory.selectFrom(wish)
				.leftJoin(wish.member, member).fetchJoin()
				.leftJoin(wish.item, item).fetchJoin()
				.where(wish.member.id.eq(memberId))
				.offset(pageable.getOffset())
				.limit(pageable.getPageSize())
				.fetch()
				; 
		
		return new PageImpl<>(content, pageable, content.size());
		
	}
}
