package com.thejoen.rabbit2.service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import com.thejoen.rabbit2.model.entity.Category;
import com.thejoen.rabbit2.model.entity.Item;
import com.thejoen.rabbit2.model.entity.Member;
import com.thejoen.rabbit2.model.network.Pagination;
import com.thejoen.rabbit2.model.network.PaginationDTO;
import com.thejoen.rabbit2.model.network.dto.item.ItemRequestDTO;
import com.thejoen.rabbit2.model.network.dto.item.ItemResponseDTO;
import com.thejoen.rabbit2.repository.CategoryRepository;
import com.thejoen.rabbit2.repository.ItemRepository;
import com.thejoen.rabbit2.repository.MemberRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ItemService {
	
	private final ItemRepository itemRepository;
	
	private final MemberRepository memberRepository;
	
	private final CategoryRepository categoryRepository;
	
	//R
	public ItemResponseDTO read(Long id) {
		Item item = itemRepository.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다."));
		
		ItemResponseDTO itemResponseDTO = new ItemResponseDTO(item);
		return itemResponseDTO;
	}//findById
	
	//C
	@Transactional
	public Long create(ItemRequestDTO itemRequestDTO) {
		
		Member seller = memberRepository.findById(itemRequestDTO.getSellerId())
			.orElseThrow(() -> new IllegalArgumentException("해당 아이디가 없습니다."));
			
		Category category = categoryRepository.findById(itemRequestDTO.getCategoryId())
				.orElseThrow(() -> new IllegalArgumentException("해당 카테고리가 없습니다."));
		
		Item item = itemRepository.save(itemRequestDTO.toEntitiy(seller,category));
		return item.getId();
	}
	
	//D
	@Transactional
	public Long delete(Long id) {
		Item item = itemRepository.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다."));
		itemRepository.delete(item);
		return id;
	}
	
	//U
	@Transactional
	public Long update(Long id, ItemRequestDTO itemRequestDTO) {
		Item item = itemRepository.findById(id).
				orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다."));
		
		String title = itemRequestDTO.getTitle();
		String content = itemRequestDTO.getContent();
		BigDecimal price = itemRequestDTO.getPrice();
		Category category = categoryRepository.findById(itemRequestDTO.getCategoryId())
				.orElseThrow(()->new IllegalArgumentException("해당 카테고리가 없습니다."));
		
		item.update(title, content, price, category);
		
		return id;
	}
	
	public PaginationDTO pagination(Page<Item> itemList) {
		
		List<ItemResponseDTO> itemResponseDTOs = itemList.stream()
				.map(item -> new ItemResponseDTO(item))
				.collect(Collectors.toList());
		Pagination pagination = Pagination.builder()
				.totalPages(itemList.getTotalPages())
				.totalElement(itemList.getTotalElements())
				.currentPage(itemList.getNumber())
				.currentElements(itemList.getNumberOfElements())
				.build()
				;
		return new PaginationDTO<List<ItemResponseDTO>>(itemResponseDTOs, pagination);
	}
	
}
