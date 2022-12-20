package com.thejoen.rabbit2.model.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@Entity
public class Region extends BaseTimeEntity{

	@Id
	@GeneratedValue(strategy =  GenerationType.IDENTITY)
	private Long id;
	
	private String district;
	
	private String city;
	
	private String town;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "region")
	private List<MyTown> MyTownList;
	
	@Builder
	public Region(String district, String city, String town) {
		this.district = district;
		this.city = city;
		this.town = town;
	}
}
