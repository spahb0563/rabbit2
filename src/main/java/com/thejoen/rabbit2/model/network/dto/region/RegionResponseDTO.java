package com.thejoen.rabbit2.model.network.dto.region;

import com.thejoen.rabbit2.model.entity.Region;

import lombok.Getter;

@Getter
public class RegionResponseDTO {
	
	private Long id;
	
	private String district;
	
	private String city;
	
	private String town;
	
	private double lat;
	
	private double lon;
	
	public RegionResponseDTO(Region region) {
		this.id = region.getId();
		this.district = region.getDistrict();
		this.city = region.getCity();
		this.town = region.getTown();
		this.lat = region.getLat();
		this.lon = region.getLon();
	}
}
