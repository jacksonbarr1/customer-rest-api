package com.example.customerrestapi;

import com.example.customerrestapi.entity.Address;
import com.example.customerrestapi.entity.Store;
import com.example.customerrestapi.repository.StoreRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class StoreRepositoryTests {

    private final Address address = Address.builder()
            .streetAddress("205 Fowler")
            .zipCode("30313")
            .build();

    private final Store store = Store.builder()
            .branchName("Jacksons")
            .revenue(100)
            .address(address)
            .build();
    @Autowired
    private StoreRepository storeRepository;
    @Autowired
    private TestEntityManager entityManager;

    @BeforeEach
    void setUp() {
        entityManager.persist(store);
    }


    @Test
    public void findAll_returnsList() {

        List<Store> fetched = storeRepository.findAll();
        System.out.println(fetched.get(0).getStoreId());
        assertEquals(fetched.get(0).getBranchName(), "Jacksons");
    }

//    @Test
//    public void findById_returnsStore() {
//
//    }

    @Test
    public void findByBranchName_returnsStore() {
        Store fetched = storeRepository.findTopByBranchNameIgnoreCase("Jacksons").get();

        assertEquals(fetched.getAddress(), address);
    }

    @Test
    public void save_returnsCustomer() {
        Store saved = storeRepository.save(store);
        assertEquals(saved.getStoreId(), store.getStoreId());
    }
}
