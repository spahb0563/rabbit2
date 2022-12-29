package com.thejoen.rabbit2.service;

import java.math.BigInteger;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thejoen.rabbit2.exception.CategoryNotFoundException;
import com.thejoen.rabbit2.exception.ItemNotFoundException;
import com.thejoen.rabbit2.exception.MemberNotFoundException;
import com.thejoen.rabbit2.exception.RegionNotFoundException;
import com.thejoen.rabbit2.model.entity.Category;
import com.thejoen.rabbit2.model.entity.Item;
import com.thejoen.rabbit2.model.entity.Member;
import com.thejoen.rabbit2.model.entity.Region;
import com.thejoen.rabbit2.model.enumclass.ItemStatus;
import com.thejoen.rabbit2.model.network.Pagination;
import com.thejoen.rabbit2.model.network.PaginationDTO;
import com.thejoen.rabbit2.model.network.dto.item.ItemCreateRequestDTO;
import com.thejoen.rabbit2.model.network.dto.item.ItemListResponseDTO;
import com.thejoen.rabbit2.model.network.dto.item.ItemResponseDTO;
import com.thejoen.rabbit2.model.network.dto.item.ItemUpdateRequestDTO;
import com.thejoen.rabbit2.repository.CategoryRepository;
import com.thejoen.rabbit2.repository.ItemRepository;
import com.thejoen.rabbit2.repository.MemberRepository;
import com.thejoen.rabbit2.repository.RegionRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ItemService {
	
	private final ItemRepository itemRepository;
	
	private final CategoryRepository categoryRepository;
	
	private final MemberRepository memberRepository;
	
	private final RegionRepository regionRepository;
	
	@Transactional
	public ResponseEntity<Long> create(ItemCreateRequestDTO request) {
		Member seller = memberRepository.findById(request.getSellerId())
				.orElseThrow(()->new MemberNotFoundException());
		
		Category category = categoryRepository.findById(request.getCategoryId())
				.orElseThrow(() -> new CategoryNotFoundException());
		
		Region region = regionRepository.findById(request.getRegionId())
				.orElseThrow(() -> new RegionNotFoundException());
				
		Item item = itemRepository.save(request.toEntitiy(seller, category, region));
		
		return ResponseEntity.status(HttpStatus.CREATED)
				.body(item.getId());
	}
	
	public ResponseEntity<ItemResponseDTO> read(Long id) {
		Item item = itemRepository.findById(id)
				.orElseThrow(() -> new ItemNotFoundException());
		
		return ResponseEntity.ok(new ItemResponseDTO(item));
	}
	
	@Transactional
	public ResponseEntity<Long> update(Long id, ItemUpdateRequestDTO request) {
		Item item = itemRepository.findById(id)
				.orElseThrow(() -> new ItemNotFoundException());
		
		Category category = categoryRepository.findById(request.getCategoryId())
				.orElseThrow(() -> new CategoryNotFoundException());
		
		item.update(request.getTitle(), request.getContent(), request.getPrice(), category);
		
		return ResponseEntity.ok(item.getId());
	}
	
	@Transactional
	public ResponseEntity delete(Long id) {
		Item item = itemRepository.findById(id)
				.orElseThrow(() -> new ItemNotFoundException());
		
		itemRepository.delete(item);
		
		return ResponseEntity.ok().build();
	}
	
	@Transactional(readOnly = true)
	public ResponseEntity<PaginationDTO<ItemListResponseDTO>> findAllBySellerId(Long sellerId, Pageable pageable) {
		
		return ResponseEntity.ok(new PaginationDTO<>(itemRepository.findAllBySellerId(sellerId, pageable)));
	}
	
	@Transactional(readOnly = true)
	public ResponseEntity<PaginationDTO<ItemListResponseDTO>> findAllByBuyerId(Long buyerId, Pageable pageable) {
	
		return ResponseEntity.ok(new PaginationDTO<>(itemRepository.findAllByBuyerId(buyerId, pageable)));
	}
	
	@Transactional(readOnly = true)
	public ResponseEntity<PaginationDTO<ItemListResponseDTO>> search(String title, 
																			BigInteger minPrice, 
																			BigInteger maxPrice, 
																			ItemStatus status, 
																			List<Long> categoryId,
																			Pageable pageable) {
		
		return ResponseEntity.ok(new PaginationDTO<>(itemRepository.search(title, minPrice, maxPrice, status, categoryId, pageable)));
	}
}
