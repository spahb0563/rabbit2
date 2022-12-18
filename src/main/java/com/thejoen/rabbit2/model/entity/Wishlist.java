package com.thejoen.rabbit2.model.entity;

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
public class Wishlist {
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
    
	@ManyToOne
	private Member member;
	
	@ManyToOne
	private Item item;

	@Builder
	public Wishlist(Member member, Item item) {
		super();
		this.member = member;
		this.item = item;
	}
}
