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
public class Wish extends BaseTimeEntity{
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
    
	@ManyToOne
	private Member member;
	
	@ManyToOne
	private Item item;

	@Builder
	public Wish(Member member, Item item) {
		this.member = member;
		this.item = item;
	}
}
