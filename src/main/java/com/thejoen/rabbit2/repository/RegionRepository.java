package com.thejoen.rabbit2.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.thejoen.rabbit2.model.entity.Region;

public interface RegionRepository extends JpaRepository<Region, Long>{
	
	
	@Query(value ="SELECT * FROM Region WHERE district || ' ' || city || ' ' || town = :address", nativeQuery = true)
	Optional<Region> findByAddress(String address);
	
	@Query(value ="SELECT * FROM Region WHERE district || ' ' || city || ' ' || town LIKE %:address%", nativeQuery = true)
	List<Region> findAllByAddress(String address); 
	
}
