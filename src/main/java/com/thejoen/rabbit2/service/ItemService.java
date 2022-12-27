package com.thejoen.rabbit2.service;

import java.math.BigDecimal;
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
	public ResponseEntity<ItemResponseDTO> create(ItemCreateRequestDTO request) {
		
		ItemCreateRequestDTO itemRequestDTO = request;
		
		Member seller = memberRepository.findById(request.getSellerId())
				.orElseThrow(()->new MemberNotFoundException());
		
		Category category = categoryRepository.findById(request.getCategoryId())
				.orElseThrow(() -> new CategoryNotFoundException());
		
		Region region = regionRepository.findById(request.getRegionId())
				.orElseThrow(() -> new RegionNotFoundException());
				
		Item item = itemRepository.save(itemRequestDTO.toEntitiy(seller, category, region));
		
		return ResponseEntity.status(HttpStatus.CREATED)
				.body(new ItemResponseDTO(item));
	}//create
	
	public ResponseEntity<ItemResponseDTO> read(Long id) {
		Item item = itemRepository.findById(id)
				.orElseThrow(() -> new ItemNotFoundException());
		
		return ResponseEntity.ok(new ItemResponseDTO(item));
	}//read
	
	@Transactional
	public ResponseEntity<ItemResponseDTO> update(Long id, ItemUpdateRequestDTO request) {
		Item item = itemRepository.findById(id)
				.orElseThrow(() -> new ItemNotFoundException());
		
		Category category = categoryRepository.findById(request.getCategoryId())
				.orElseThrow(() -> new CategoryNotFoundException());
		
		item.update(request.getTitle(), request.getContent(), request.getPrice(), category);
		
		return ResponseEntity.ok(new ItemResponseDTO(item));
	}//update
	
	@Transactional
	public ResponseEntity delete(Long id) {
		Item item = itemRepository.findById(id)
				.orElseThrow(() -> new ItemNotFoundException());
		
		itemRepository.delete(item);
		
		return ResponseEntity.ok().build();
	}
	
	@Transactional(readOnly = true)
	public ResponseEntity<PaginationDTO<List<ItemListResponseDTO>>> search(String title, BigDecimal minPrice, BigDecimal maxPrice,
			Pageable pageable) {
		
		return ResponseEntity.ok(pagination(itemRepository.search(title, minPrice, maxPrice, pageable)));
	}
	
    private PaginationDTO<List<ItemListResponseDTO>> pagination(Page<Item> itemList) {
        List<ItemListResponseDTO> itemListResponseDTOs = itemList.stream()
                .map(item -> new ItemListResponseDTO(item))
                .collect(Collectors.toList());

        Pagination pagination = Pagination.builder()
                .totalPages(itemList.getTotalPages())
                .totalElements(itemList.getTotalElements())
                .currentPage(itemList.getNumber())
                .currentElements(itemList.getNumberOfElements())
                .build();
        		
        return new PaginationDTO(itemListResponseDTOs, pagination);
    }
	
	
	
	
	
	
	
	
	
	
	
}
