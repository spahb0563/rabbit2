package com.thejoen.rabbit2.security.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.thejoen.rabbit2.exception.MemberNotFoundException;
import com.thejoen.rabbit2.model.entity.Member;
import com.thejoen.rabbit2.repository.MemberRepository;

@Service("userDetailService")
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private MemberRepository memberRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
       	Member account =  memberRepository.findByEmail(email)
    		   .orElseThrow(() -> new MemberNotFoundException());

    	//계정이 갖고 있는 권한 목록
    	List<GrantedAuthority> roles = new ArrayList<>();
    	roles.add(new SimpleGrantedAuthority(account.getRole().getTitle())); // 권한 주기

    	return new AccountContext(account, roles);  //User를 상속 User는 UserDetails를 구현하고 있음
    }
}
