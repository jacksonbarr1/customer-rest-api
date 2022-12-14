package com.example.customerrestapi.service;

import com.example.customerrestapi.entity.Customer;
import com.example.customerrestapi.error.CustomerNotFoundException;

import java.util.List;

public interface CustomerService {

    Customer saveCustomer(Customer customer);

    List<Customer> findAllCustomers();

    Customer findCustomerById(Long id) throws CustomerNotFoundException;

    Customer findCustomerByName(String name) throws CustomerNotFoundException;

    void deleteCustomerById(Long id) throws CustomerNotFoundException;

    void deleteCustomer(Customer customer);
}
