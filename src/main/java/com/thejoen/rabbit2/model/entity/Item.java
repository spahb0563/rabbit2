package com.thejoen.rabbit2.model.entity;

import java.math.BigInteger;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.thejoen.rabbit2.model.enumclass.ItemStatus;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
@Entity
public class Item extends BaseTimeEntity{
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
    
    @Column(nullable = false)
	private String title;
	
    @Column(nullable = false)
	private String content;
	
    @Column(nullable = false)
	private BigInteger price;
	
	@Enumerated(EnumType.STRING)
	private ItemStatus status;
	
	private int viewCount;
	
	private int likeCount;
	
	@ManyToOne
	private Member buyer;
	
	@ManyToOne
	private Member seller;
	
	@ManyToOne
	private Category category;
	
	@ManyToOne
	private Region region;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "item")
	private List<Wish> wishList;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "item")
	private List<File> fileList;
	
	@Builder
	public Item(String title, String content, BigInteger price, ItemStatus status, Member seller, Category category, Region region) {
		this.title = title;
		this.content = content;
		this.price = price;
		this.status = status;
		this.seller = seller;
		this.category = category;
		this.region = region;
	}

	public void update(String title, String content, BigInteger price, Category category) {
		this.title = title;
		this.content = content;
		this.price = price;
		this.category = category;
	}
}
