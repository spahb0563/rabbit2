package com.thejoen.rabbit2.model.entity;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
@Entity
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
    
	private String email;
	private String password;
	private String nickname;
	private String name;
	private String address;
	private String zipcode;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "target")
	private List<Review> recievedReview;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "writer")
	private List<Review> writedReview;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "buyer")
	private List<Item> buyItem;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "seller")
	private List<Item> sellItem;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "receiver")
	private List<Message> reveiveMessage;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "sender")
	private List<Message> sendMessage;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "member")
	private List<Wishlist> wishlist;
	
	private LocalDateTime createdAt;
	private LocalDateTime updatedAt;
	 
	@Builder
	public Member(String email, String password, String nickname, String name, String address, String zipcode) {
		this.email = email;
		this.password = password;
		this.nickname = nickname;
        this.name = name;
        this.address = address;
        this.zipcode = zipcode;
    }
	 

}
