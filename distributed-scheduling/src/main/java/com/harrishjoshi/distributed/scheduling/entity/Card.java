package com.harrishjoshi.distributed.scheduling.entity;

import com.harrishjoshi.distributed.scheduling.enums.CardStatus;
import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table
public class Card {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String cardType;
    private String cardNumber;
    private LocalDate expirationDate;
    @Enumerated(EnumType.STRING)
    private CardStatus status;
    private String cvv;
    @OneToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;
}
