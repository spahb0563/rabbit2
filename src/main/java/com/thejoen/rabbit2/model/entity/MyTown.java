package com.thejoen.rabbit2.model.entity;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.thejoen.rabbit2.model.enumclass.MyTownStatus;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@Entity
public class MyTown extends BaseTimeEntity{
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne
	private Region region;
	
	@ManyToOne
	private Member member;
	
	@Enumerated(EnumType.STRING)
	private MyTownStatus status;
	
	@Builder
	public MyTown(Region region, Member member, MyTownStatus status) {
		this.region = region;
		this.member = member;
		this.status = status;
	}
}
