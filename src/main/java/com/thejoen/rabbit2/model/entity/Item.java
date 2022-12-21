package com.thejoen.rabbit2.model.entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;
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

import org.hibernate.annotations.ColumnDefault;

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
	private BigDecimal price;
	
	@Enumerated(EnumType.STRING)
	private ItemStatus status;
	
	private int view_count;
	
	private int like_count;
	
	@ManyToOne
	private Member buyer;
	
	@ManyToOne
	private Member seller;
	
	@ManyToOne
	private Category category;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "item")
	private List<WishList> wishList;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "item")
	private List<File> fileList;
	
	@Builder
	public Item(String title, String content, BigDecimal price, Member seller, Category category) {
		this.title = title;
		this.content = content;
		this.price = price;
		this.seller = seller;
		this.category = category;
	}

	public void update(String title, String content, BigDecimal price, Category category) {
		this.title = title;
		this.content = content;
		this.price = price;
		this.category = category;
	}
}
