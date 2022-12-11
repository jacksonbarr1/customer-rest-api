package com.example.customerrestapi.service;

import com.example.customerrestapi.entity.Customer;
import org.springframework.data.repository.ListCrudRepository;

import java.util.List;

public interface CustomerService {

    Customer saveCustomer(Customer customer);

    List<Customer> findAllCustomers();

    Customer findCustomerById(Long id) throws Exception;

}
