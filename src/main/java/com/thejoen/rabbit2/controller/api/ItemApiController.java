package com.thejoen.rabbit2.controller.api;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.thejoen.rabbit2.model.network.PaginationDTO;
import com.thejoen.rabbit2.model.network.dto.item.ItemCreateRequestDTO;
import com.thejoen.rabbit2.model.network.dto.item.ItemListResponseDTO;
import com.thejoen.rabbit2.model.network.dto.item.ItemResponseDTO;
import com.thejoen.rabbit2.model.network.dto.item.ItemUpdateRequestDTO;
import com.thejoen.rabbit2.service.ItemService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RequestMapping("/api/v1")
@RestController
public class ItemApiController {
	
	private final ItemService itemService;
	
	@GetMapping("/item/{id}")
	public ResponseEntity<ItemResponseDTO> read(@PathVariable Long id) {
		return itemService.read(id);
	}
	
	@PostMapping("/item")
	public ResponseEntity<ItemResponseDTO> create(@RequestBody ItemCreateRequestDTO request) {
		return itemService.create(request);
	}
	
	@PutMapping("/item/{id}")
	public ResponseEntity<ItemResponseDTO> update(@PathVariable Long id, @RequestBody ItemUpdateRequestDTO request) {
		return itemService.update(id, request);
	}
	
	@DeleteMapping("/item/{id}")
	public ResponseEntity delete(@PathVariable Long id) { 
		return itemService.delete(id);
	}
	
	@GetMapping("/item")
	public ResponseEntity<PaginationDTO<List<ItemListResponseDTO>>> search(@RequestParam(required = false) String title,
																	@RequestParam(required = false) BigDecimal minPrice,
																	@RequestParam(required = false) BigDecimal maxPrice,
																	@PageableDefault(sort = "id", direction = Sort.Direction.DESC) Pageable pageable){
		
		return itemService.search(title, minPrice, maxPrice, pageable);
	}
	
}
