package com.example.customerrestapi.repository;

import com.example.customerrestapi.entity.Customer;
import org.springframework.data.repository.ListCrudRepository;

import java.util.Optional;

public interface CustomerRepository extends ListCrudRepository<Customer, Long> {
    Optional<Customer> findTopByNameIgnoreCase(String name);
}
