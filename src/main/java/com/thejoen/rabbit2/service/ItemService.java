package com.thejoen.rabbit2.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.thejoen.rabbit2.exception.ItemNotFoundException;
import com.thejoen.rabbit2.model.entity.Item;
import com.thejoen.rabbit2.model.network.dto.item.ItemRequestDTO;
import com.thejoen.rabbit2.model.network.dto.item.ItemResponseDTO;
import com.thejoen.rabbit2.repository.ItemRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ItemService {
	
	private final ItemRepository itemRepository;
	
	
	public ResponseEntity<ItemResponseDTO> read(Long id) {
		Item item = itemRepository.findById(id)
				.orElseThrow(() -> new ItemNotFoundException());
		
		return ResponseEntity.ok(new ItemResponseDTO(item));
		
	}//read
	
	public ResponseEntity<ItemResponseDTO> create(ItemRequestDTO request) {
		
		ItemRequestDTO itemRequestDTO = request;
		
		Item item = itemRequestDTO.toEntitiy(null, null);
		
		Item newItem = itemRepository.save(item);
		
 		ItemResponseDTO itemResponseDTO = new ItemResponseDTO(newItem);
		
		return null;
	}
	
	
}
