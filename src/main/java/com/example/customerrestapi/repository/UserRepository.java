package com.example.customerrestapi.repository;

import com.example.customerrestapi.entity.UserEntity;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.security.core.userdetails.User;

public interface UserRepository extends ListCrudRepository<UserEntity, Integer> {
    User findByUsername(String username);
}
