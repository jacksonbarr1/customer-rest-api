package com.example.customerrestapi.controller;

import com.example.customerrestapi.entity.Customer;
import com.example.customerrestapi.error.CustomerNotFoundException;
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

    @PutMapping("/customer/{id:\\d+}")
    public Customer updateCustomer(@PathVariable Long id, @RequestBody Customer customer) {
        customer.setCustomerId(id);
        return customerService.saveCustomer(customer);
    }

    @GetMapping("/customer/{id:\\d+}")
    public Customer findCustomerById(@PathVariable Long id) throws CustomerNotFoundException {
        return customerService.findCustomerById(id);
    }

    @GetMapping("/customer")
    public List<Customer> findAllCustomers() {
        return customerService.findAllCustomers();
    }

    @GetMapping("/customer/{name:[a-zA-Z]+}")
    public Customer findCustomerByName(@PathVariable String name) throws CustomerNotFoundException {
        return customerService.findCustomerByName(name);
    }

    @DeleteMapping("/customer/{id}")
    public void deleteById(@PathVariable Long id) throws CustomerNotFoundException {
        customerService.deleteCustomerById(id);
    }


}
