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
public class Message {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
    
	private String content;
	private Integer status;
	private LocalDateTime createdAt;
	
	@ManyToOne
	private Member receiver;
	
	@ManyToOne
	private Member sender;
	
	@Builder
	public Message(String content, Integer status,Member receiver,Member sender) {
		this.content = content;
		this.status = status;
		this.receiver = receiver;
		this.sender = sender;
    }


}
