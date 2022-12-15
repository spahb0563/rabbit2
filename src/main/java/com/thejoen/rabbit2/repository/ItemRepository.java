package com.thejoen.rabbit2.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.thejoen.rabbit2.model.entity.Item;

@Repository
public interface ItemRepository extends JpaRepository<Item, Long>{
	List<Item> findAllByTitle(String title);
}
