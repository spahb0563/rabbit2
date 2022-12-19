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
public class Review {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String content;

	
	@ManyToOne
	private Member target;
	
	@ManyToOne
	private Member writer;
	
	@Builder
	public Review(String content,Member target,Member writer) {
		this.content = content;
		this.target = target;
		this.writer = writer;
	}



}
