package com.example.customerrestapi.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Store {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long storeId;

    private String branchName;

    private int revenue;

    @OneToOne(
            cascade = CascadeType.ALL
    )
    @JoinColumn(
            name = "address_id",
            referencedColumnName = "addressId"
    )
    private Address address;

    @OneToMany(
            cascade = CascadeType.ALL
    )
    @JoinTable(
            name = "store_customers",
            joinColumns = @JoinColumn(name = "store_id"),
            inverseJoinColumns = @JoinColumn(name = "customer_id")
    )
    private List<Customer> customers;
}
