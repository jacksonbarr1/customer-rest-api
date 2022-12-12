package com.example.customerrestapi.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String streetAddress;

    private String zipCode;

    @OneToOne(
            cascade = CascadeType.ALL
    )
    @JoinColumn(
            name = "store_id",
            referencedColumnName = "storeId"
    )
    private Store store;
}
