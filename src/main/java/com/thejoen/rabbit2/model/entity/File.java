package com.thejoen.rabbit2.model.entity;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
@Entity
public class File {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String name;
	
	private String savedname;
	
	private String path;
	
	private Integer size;
	
	private String type;
	
	private LocalDateTime createdAt;
	
	@ManyToOne
	private Item item;
	
	@Builder
	public File(String name, String savedname, String path, Integer size, String type, Item item) {
		this.name = name;
		this.savedname = savedname;
		this.path = path;
		this.size = size;
		this.type = type;
		this.item = item;
	}


	
	
	
	

}
