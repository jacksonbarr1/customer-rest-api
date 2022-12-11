package com.example.customerrestapi.controller;

import com.example.customerrestapi.entity.Customer;
import com.example.customerrestapi.service.CustomerService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @PostMapping("/customer")
    public Customer saveCustomer(@Valid @RequestBody Customer customer) {
        return customerService.saveCustomer(customer);
    }

    @GetMapping("/customer")
    public List<Customer> findAllCustomers() {
        return customerService.findAllCustomers();
    }

    @GetMapping("/customer/{id}")
    public Customer findCustomerById(@PathVariable Long id) throws Exception {
        return customerService.findCustomerById(id);
    }
}
