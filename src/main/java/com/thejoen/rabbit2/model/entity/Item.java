package com.thejoen.rabbit2.model.entity;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
@Entity
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
    
	private String title;
	private String content;
	private Integer price;
	private String status;
	private Integer view_count;
	private Integer like_count;
	private LocalDateTime createdAt;
	private LocalDateTime updatedAt;
	
	@ManyToOne
	private Member buyer;
	
	@ManyToOne
	private Member seller;
	
	@ManyToOne
	private Category category;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "wishitem")
	private List<Wishlist> wishList;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "fileitem")
	private List<File> file;
	
	
	@Builder
	public Item(String title, String content, Integer price, String status, 
			Integer view_count, Integer like_count,
			Member buyer,Member seller,Category category) {
		this.title = title;
		this.content = content;
		this.price = price;
		this.status = status;
		this.view_count = view_count;
		this.like_count = like_count;
	}
	
	

}
