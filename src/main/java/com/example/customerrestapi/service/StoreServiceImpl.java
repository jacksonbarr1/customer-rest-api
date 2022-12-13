package com.example.customerrestapi.service;

import com.example.customerrestapi.entity.Store;
import com.example.customerrestapi.error.StoreNotFoundException;
import com.example.customerrestapi.repository.StoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StoreServiceImpl implements StoreService {
    @Autowired
    StoreRepository storeRepository;

    @Override
    public Store saveStore(Store store) {
        return storeRepository.save(store);
    }

    @Override
    public List<Store> findAllStores() {
        return storeRepository.findAll();
    }

    @Override
    public Store findStoreById(Long id) throws StoreNotFoundException {
        Optional<Store> store = storeRepository.findById(id);
        if (store.isEmpty()) {
            throw new StoreNotFoundException("Store not found");
        }

        return store.get();
    }

    @Override
    public Store findStoreByBranchName(String name) throws StoreNotFoundException {
        Optional<Store> store = storeRepository.findTopByBranchNameIgnoreCase(name);
        if (store.isEmpty()) {
            throw new StoreNotFoundException("Store not found");
        }

        return store.get();
    }

    @Override
    public void deleteStoreById(Long id) throws StoreNotFoundException {
        Store store = findStoreById(id);
        deleteStore(store);

    }

    @Override
    public void deleteStore(Store store) {
        storeRepository.delete(store);

    }
}
