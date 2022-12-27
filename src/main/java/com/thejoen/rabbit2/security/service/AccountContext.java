package com.thejoen.rabbit2.security.service;


import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import com.thejoen.rabbit2.model.entity.Member;

public class AccountContext extends User {

    private final Member account;

    public AccountContext(Member account, Collection<? extends GrantedAuthority> authorities) {
        super(account.getEmail(), account.getPassword(), authorities);

        this.account = account;
    }

    public Member getAccount() {
        return this.account;
    }
}
