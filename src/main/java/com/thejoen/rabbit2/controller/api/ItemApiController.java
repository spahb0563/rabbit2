package com.thejoen.rabbit2.controller.api;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.thejoen.rabbit2.model.network.dto.item.ItemRequestDTO;
import com.thejoen.rabbit2.model.network.dto.item.ItemResponseDTO;
import com.thejoen.rabbit2.service.ItemService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api")
public class ItemApiController {
	private final ItemService itemService;
	
	@GetMapping("/v1/item/{id}")
	public ItemResponseDTO read(@PathVariable Long id) {
		return itemService.read(id);
	}
	
	@PostMapping("/v1/item")
	public Long create(@RequestBody ItemRequestDTO itemRequestDTO) {
		return itemService.create(itemRequestDTO);
	}
	
	@PutMapping("/v1/item/{id}")
	public Long update(@PathVariable Long id, @RequestBody ItemRequestDTO itemRequestDTO) {
		return itemService.update(id, itemRequestDTO);
	}
	
	@DeleteMapping("/v1/item/{id}")
	public Long delete(@PathVariable Long id) {
		return itemService.delete(id);
	}
}
