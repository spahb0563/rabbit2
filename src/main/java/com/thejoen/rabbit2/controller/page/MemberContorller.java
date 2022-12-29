package com.thejoen.rabbit2.controller.page;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.thejoen.rabbit2.model.network.PaginationDTO;
import com.thejoen.rabbit2.model.network.dto.item.ItemListResponseDTO;
import com.thejoen.rabbit2.service.ItemService;
import com.thejoen.rabbit2.service.MemberService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RequestMapping("/member")
@Controller
public class MemberContorller {
	
	private final MemberService memberService;
	
	private final ItemService itemService;
	
	
	
	@GetMapping("/my-info")
	public String info(Model model) {
		
		return "/member/my-info";
	}
	
	@GetMapping("/wishlist")
	public String wishlist(Model model) {
		
		
		
		
		
		return "/member/wishlist";
	}
	
	@GetMapping("/sales-item")
	public String salesItem(Model model, @PageableDefault(sort = "id", direction = Sort.Direction.DESC) Pageable pageable) {
		
		PaginationDTO<ItemListResponseDTO> paginationDTO = itemService.findAllBySellerId(1L, pageable).getBody();
		model.addAttribute("itemList", paginationDTO.getData());
		model.addAttribute("page", paginationDTO.getPagination());
		
		return "/member/sales-item";
	}
	
	@GetMapping("/purchased-item")
	public String purchasedItem(Model model, @PageableDefault(sort = "id", direction = Sort.Direction.DESC) Pageable pageable) {
		
		PaginationDTO<ItemListResponseDTO> paginationDTO = itemService.findAllByBuyerId(1L, pageable).getBody();
		
		model.addAttribute("itemList", paginationDTO.getData());
		model.addAttribute("page", paginationDTO.getPagination());
		
		return "/member/purchased-item";
	}
	
	
	
	
	
}
