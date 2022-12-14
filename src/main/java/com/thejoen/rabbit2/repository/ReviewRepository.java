package com.thejoen.rabbit2.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.thejoen.rabbit2.model.entity.Review;

public interface ReviewRepository extends JpaRepository<Review, Long>{

}
