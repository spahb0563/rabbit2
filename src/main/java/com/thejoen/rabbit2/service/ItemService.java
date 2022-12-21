package com.thejoen.rabbit2.service;

import javax.transaction.Transactional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.thejoen.rabbit2.exception.CategoryNotFoundException;
import com.thejoen.rabbit2.exception.ItemNotFoundException;
import com.thejoen.rabbit2.exception.MemberNotFoundException;
import com.thejoen.rabbit2.model.entity.Category;
import com.thejoen.rabbit2.model.entity.Item;
import com.thejoen.rabbit2.model.entity.Member;
import com.thejoen.rabbit2.model.network.dto.item.ItemCreateRequestDTO;
import com.thejoen.rabbit2.model.network.dto.item.ItemResponseDTO;
import com.thejoen.rabbit2.model.network.dto.item.ItemUpdateRequestDTO;
import com.thejoen.rabbit2.repository.CategoryRepository;
import com.thejoen.rabbit2.repository.ItemRepository;
import com.thejoen.rabbit2.repository.MemberRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ItemService {
	
	private final ItemRepository itemRepository;
	
	private final CategoryRepository categoryRepository;
	
	private final MemberRepository memberRepository;
	
	@Transactional
	public ResponseEntity<ItemResponseDTO> create(ItemCreateRequestDTO request) {
		
		ItemCreateRequestDTO itemRequestDTO = request;
		
		Member seller = memberRepository.findById(request.getSellerId())
				.orElseThrow(()->new MemberNotFoundException());
		
		Category category = categoryRepository.findById(request.getCategoryId())
				.orElseThrow(() -> new CategoryNotFoundException());
		
		Item item = itemRequestDTO.toEntitiy(seller, category);
		
		return ResponseEntity.status(HttpStatus.CREATED)
				.body(new ItemResponseDTO(itemRepository.save(item)));
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
	}//delete
	
	
}
