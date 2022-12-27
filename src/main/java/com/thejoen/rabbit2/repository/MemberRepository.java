package com.thejoen.rabbit2.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.thejoen.rabbit2.model.entity.Member;

public interface MemberRepository extends JpaRepository<Member, Long>{
	
	Optional<Member> findByEmail(String email);
}
