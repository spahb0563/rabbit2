package com.thejoen.rabbit2.model.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import lombok.Getter;

@Getter
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public abstract class BaseTimeEntity {
	
	@Column(nullable = false, updatable = false)
    @CreatedDate
    private LocalDateTime createdAt;
	
	@Column(nullable = false)
    @LastModifiedDate
    private LocalDateTime updatedAt;
	
}
