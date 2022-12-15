package com.thejoen.rabbit2.model.entity;

import java.time.LocalDateTime;
import java.util.List;

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
	private Item wishitem;

	@Builder
	public Wishlist(Member member, Item wishitem) {
		super();
		this.member = member;
		this.wishitem = wishitem;
	}

}
