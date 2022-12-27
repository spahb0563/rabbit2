package com.thejoen.rabbit2.controller.api;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.thejoen.rabbit2.model.network.dto.region.RegionListResponseDTO;
import com.thejoen.rabbit2.service.RegionService;

import lombok.EqualsAndHashCode;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1")
public class RegionApiContoller {

	private final RegionService regionService;
	
	@GetMapping("/region")
	public ResponseEntity<List<RegionListResponseDTO>> search(@RequestParam String address) {
		
		regionService.equals(address);
		
		return regionService.search(address);
	}
	
	String a;
}
