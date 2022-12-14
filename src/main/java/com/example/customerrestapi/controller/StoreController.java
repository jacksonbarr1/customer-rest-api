package com.example.customerrestapi.controller;

import com.example.customerrestapi.entity.Customer;
import com.example.customerrestapi.entity.Store;
import com.example.customerrestapi.error.StoreNotFoundException;
import com.example.customerrestapi.service.StoreService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StoreController {

    @Autowired
    private StoreService storeService;

    @PostMapping("/store")
    public Store saveStore(@Valid @RequestBody Store store) {
        return storeService.saveStore(store);
    }

    @GetMapping("/store/{id:\\d+}")
    public Store findStoreById(@PathVariable Long id) throws StoreNotFoundException {
        return storeService.findStoreById(id);
    }

    @GetMapping("/store")
    public List<Store> findAllStores() {
        return storeService.findAllStores();
    }

    @GetMapping("/store/{name:[a-zA-Z]+}")
    public Store findStoreByBranchName(@PathVariable String name) throws StoreNotFoundException {
        return storeService.findStoreByBranchName(name);
    }

    @DeleteMapping("/store/{id}")
    public void deleteById(@PathVariable Long id) throws StoreNotFoundException {
        storeService.deleteStoreById(id);
    }

    @GetMapping("store/{id}/customers")
    public List<Customer> findCustomersByStoreId(@PathVariable Long id) throws StoreNotFoundException {
        Store store = storeService.findStoreById(id);
        return store.getCustomers();
    }
}
