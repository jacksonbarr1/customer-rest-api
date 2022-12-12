package com.example.customerrestapi;

import com.example.customerrestapi.entity.Customer;
import com.example.customerrestapi.repository.CustomerRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class CustomerRepositoryTests {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private TestEntityManager entityManager;

    @BeforeEach
    void setUp() {
        Customer customer = Customer.builder()
                .name("Jackson")
                .email("jacksonbarr2021@gmail.com")
                .build();

        entityManager.persist(customer);
    }

    @Test
    public void findById_returnsCustomer() {
        Customer customer = customerRepository.findById(1L).get();

        assertEquals(customer.getName(), "Jackson");
    }

    @Test
    public void findByName_caseDoesntMatter() {
        Customer customer = customerRepository.findTopByNameIgnoreCase("jACKSOn").get();

        assertEquals(customer.getName(), "Jackson");
    }
}
