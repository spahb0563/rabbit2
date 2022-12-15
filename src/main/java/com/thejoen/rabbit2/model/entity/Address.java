package com.thejoen.rabbit2.model.entity;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
@Entity
public class Address {
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
    
	private String city;
	
	private String district;
	
	@Builder
	public Address(String city, String district) {
		this.city = city;
		this.district = district;
	}
	

	
    
    

}
