package com.example.customerrestapi;

import com.example.customerrestapi.entity.Customer;
import com.example.customerrestapi.error.CustomerNotFoundException;
import com.example.customerrestapi.repository.CustomerRepository;
import com.example.customerrestapi.service.CustomerService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@SpringBootTest
public class CustomerServiceTests {

    private final Customer customer = new Customer(1L, "Jackson", "jacksonbarr2021@gmail.com");
    @Autowired
    private CustomerService customerService;
    @MockBean
    private CustomerRepository customerRepository;

    @BeforeEach
    void setUp() {
        List<Customer> customerList = new ArrayList<>();
        customerList.add(customer);
        customerList.add(customer);

        Mockito.when(customerRepository.save(customer))
                .thenReturn(customer);
        Mockito.when(customerRepository.findByNameIgnoreCase("Jackson"))
                .thenReturn(Optional.of(customer));
        Mockito.when(customerRepository.findById(1L))
                .thenReturn(Optional.of(customer));
        Mockito.when(customerRepository.findAll())
                .thenReturn(customerList);
    }

    @Test
    public void savingCustomer_returnsCustomer() {
        Customer saved = customerService.saveCustomer(customer);
        assertEquals(saved, customer);
    }

    @Test
    public void validCustomerName_findsCustomer() throws CustomerNotFoundException {
        String name = "Jackson";
        Customer fetched = customerService.findCustomerByName(name);
        assertEquals(name, fetched.getName());
    }

    @Test
    public void validCustomerId_findsCustomer() throws CustomerNotFoundException {
        Long id = 1L;
        Customer fetched = customerService.findCustomerById(id);
        assertEquals(id, fetched.getId());
    }

    @Test
    public void findAll_returnsCustomerList() {
        List<Customer> fetchedList = customerService.findAllCustomers();
        assertEquals(customer, fetchedList.get(0));
    }

    @Test
    public void deleteCustomerById_deletes() throws CustomerNotFoundException {
        Long id = 1L;

        customerService.deleteCustomerById(id);

        verify(customerRepository, times(1)).delete(customer);
    }

    @Test
    public void deleteCustomer_deletes() {
        customerService.deleteCustomer(customer);
        verify(customerRepository, times(1)).delete(customer);
    }

}
