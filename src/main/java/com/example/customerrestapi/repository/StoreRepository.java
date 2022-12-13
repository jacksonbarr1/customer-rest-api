package com.example.customerrestapi.repository;

import com.example.customerrestapi.entity.Store;
import org.springframework.data.repository.ListCrudRepository;

import java.util.Optional;

public interface StoreRepository extends ListCrudRepository<Store, Long> {

    Optional<Store> findTopByBranchNameIgnoreCase(String name);
}
