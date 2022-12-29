package com.thejoen.rabbit2.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.thejoen.rabbit2.model.entity.Wish;

public interface WishRepositoryCustom {
	Page<Wish> findAllByMemberId(Long memberId, Pageable pageable); 
}
