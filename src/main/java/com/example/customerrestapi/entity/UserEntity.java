package com.example.customerrestapi.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.ArrayList;
import java.util.Collection;

@Entity
public class UserEntity extends User {

    @Id
    private int id;

    private String username;

    public UserEntity(String username, String password, Collection<? extends GrantedAuthority> authorities) {
        super(username, password, authorities);
    }

    public UserEntity() {
        super("", "", new ArrayList<GrantedAuthority>());
    }

}
