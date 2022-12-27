package com.thejoen.rabbit2.model.network.dto.region;

import com.thejoen.rabbit2.model.entity.Region;

import lombok.Getter;

@Getter
public class RegionListResponseDTO {
	private Long id;
	
	private String address;
	
	private double lat;
	
	private double lon;
	
	public RegionListResponseDTO(Region region) {
		this.id = region.getId();
		this.address = region.getDistrict() + " " + region.getCity() + " " + region.getTown(); 
		this.lat = region.getLat();
		this.lon = region.getLon();
	}
}
