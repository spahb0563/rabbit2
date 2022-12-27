package com.thejoen.rabbit2.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thejoen.rabbit2.model.network.dto.region.RegionListResponseDTO;
import com.thejoen.rabbit2.repository.RegionRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class RegionService {
	
	private final RegionRepository regionRepository;
	
	@Transactional(readOnly = true)
	public ResponseEntity<List<RegionListResponseDTO>> search(String address) {
		List<RegionListResponseDTO> regionListReponseDTOs = 
				regionRepository.findAllByAddress(address).stream()
				.map(region -> new RegionListResponseDTO(region))
				.collect(Collectors.toList()); 
		
		return ResponseEntity.ok(regionListReponseDTOs);
	}
}
