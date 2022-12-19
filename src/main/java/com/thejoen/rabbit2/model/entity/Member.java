package com.thejoen.rabbit2.model.entity;

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
public class Member extends BaseTimeEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
    
	private String email;
	
	private String password;
	
	private String nickname;
	
	private String name;
	
	private String picture;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "member")
	private List<MyTown> myTownList;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "target")
	private List<Review> recievedReview;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "writer")
	private List<Review> writedReview;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "buyer")
	private List<Item> purchasedItemList;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "seller")
	private List<Item> salesItemList;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "receiver")
	private List<Message> receivedMessageList;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "sender")
	private List<Message> sentMessageList;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "member")
	private List<WishList> wishList;
	 
	@Builder
	public Member(String email, String password, String nickname, String name) {
		this.email = email;
		this.password = password;
		this.nickname = nickname;
        this.name = name;
    }
}
