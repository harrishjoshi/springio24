package com.harrishjoshi.distributed.scheduling.entity;

import com.harrishjoshi.distributed.scheduling.enums.CustomerStatus;
import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;
    private String phone;
    @Enumerated(EnumType.STRING)
    private CustomerStatus status;
    private LocalDate dateOfBirth;
    private String address;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "customer")
    private Card card;
}
