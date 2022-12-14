package com.example.customerrestapi.service;

import com.example.customerrestapi.entity.Customer;
import com.example.customerrestapi.error.CustomerNotFoundException;
import com.example.customerrestapi.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    CustomerRepository customerRepository;

    @Override
    public Customer saveCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    @Override
    public List<Customer> findAllCustomers() {
        return customerRepository.findAll();
    }

    @Override
    public Customer findCustomerById(Long id) throws CustomerNotFoundException {
        Optional<Customer> customer = customerRepository.findById(id);
        if (customer.isEmpty()) {
            throw new CustomerNotFoundException("Customer not found");
        }

        return customer.get();
    }

    @Override
    public Customer findCustomerByName(String name) throws CustomerNotFoundException {
        Optional<Customer> customer = customerRepository.findTopByNameIgnoreCase(name);
        if (customer.isEmpty()) {
            throw new CustomerNotFoundException("Customer with name " + name + " not found.");
        }

        return customer.get();
    }

    @Override
    public void deleteCustomerById(Long id) throws CustomerNotFoundException {
        Customer customer = findCustomerById(id);
        deleteCustomer(customer);
    }

    @Override
    public void deleteCustomer(Customer customer) {
        customerRepository.delete(customer);
    }
}
