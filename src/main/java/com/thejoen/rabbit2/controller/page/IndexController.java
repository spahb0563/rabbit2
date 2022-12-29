package com.thejoen.rabbit2.controller.page;

import java.math.BigInteger;
import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.thejoen.rabbit2.model.enumclass.ItemStatus;
import com.thejoen.rabbit2.model.network.PaginationDTO;
import com.thejoen.rabbit2.model.network.dto.item.ItemListResponseDTO;
import com.thejoen.rabbit2.service.ItemService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
public class IndexController {
	
	private final ItemService itemService;
	
	
	@GetMapping("/")
	public String index(@RequestParam(required = false) String title,
						@RequestParam(required = false) BigInteger minPrice,
						@RequestParam(required = false) BigInteger maxPrice,
						@RequestParam(required = false) ItemStatus status,
						@RequestParam(required = false) List<Long> categoryId, 
						@PageableDefault(sort = "id", direction = Sort.Direction.DESC) Pageable pageable,
						Model model) {
		
		PaginationDTO<ItemListResponseDTO> paginationDTO = itemService.search(title, minPrice, maxPrice, status, categoryId, pageable).getBody();
		
        model.addAttribute("itemList", paginationDTO.getData());
        model.addAttribute("page", paginationDTO.getPagination());
//		
//		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//		
//		
//		if(authentication != null) {
//			Member member = (Member)authentication.getPrincipal();
//			
//			System.out.println(member.getId());
//			System.out.println(member.getEmail());
//			System.out.println(member.getPassword());
//		}
		return "index";
	}
	
}
