package com.example.customerrestapi.repository;

import com.example.customerrestapi.entity.Customer;
import org.springframework.data.repository.ListCrudRepository;

public interface CustomerRepository extends ListCrudRepository<Customer, Long> {
}
