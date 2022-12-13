package com.example.customerrestapi.service;

import com.example.customerrestapi.entity.Store;
import com.example.customerrestapi.error.StoreNotFoundException;

import java.util.List;

public interface StoreService {

    Store saveStore(Store store);

    List<Store> findAllStores();

    Store findStoreById(Long id) throws StoreNotFoundException;

    Store findStoreByBranchName(String name) throws StoreNotFoundException;

    void deleteStoreById(Long id) throws StoreNotFoundException;

    void deleteStore(Store store);


}
