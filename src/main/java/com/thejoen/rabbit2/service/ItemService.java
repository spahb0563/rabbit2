package com.thejoen.rabbit2.service;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.thejoen.rabbit2.model.entity.Item;
import com.thejoen.rabbit2.model.network.dto.item.ItemRequestDTO;
import com.thejoen.rabbit2.model.network.dto.item.ItemResponseDTO;
import com.thejoen.rabbit2.repository.ItemRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ItemService {
	
	private final ItemRepository itemRepository;
	
	
	public ItemResponseDTO findById(Long id) {
		Item item = itemRepository.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다."));
		
		ItemResponseDTO itemResponseDTO = new ItemResponseDTO(item);
		return itemResponseDTO;
	}//findById
	
	public ResponseEntity<ItemResponseDTO> create(RequestEntity<ItemRequestDTO> request) {
		
		ItemRequestDTO itemRequestDTO = request.getBody();
		
		Item item = itemRequestDTO.toEntitiy(null, null);
		
		Item newItem = itemRepository.save(item);
		
		ItemResponseDTO itemResponseDTO = new ItemResponseDTO(newItem);
		
		HttpHeaders headers= new HttpHeaders();
		
		return ResponseEntity
				.ok()
				.headers(headers)
				.body(itemResponseDTO)
				;
	}
	
	
}
