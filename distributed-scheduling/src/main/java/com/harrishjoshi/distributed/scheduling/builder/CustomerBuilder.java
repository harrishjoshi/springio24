package com.harrishjoshi.distributed.scheduling.builder;

import com.harrishjoshi.distributed.scheduling.entity.Card;
import com.harrishjoshi.distributed.scheduling.entity.Customer;
import com.harrishjoshi.distributed.scheduling.enums.CustomerStatus;

import java.time.LocalDate;

public final class CustomerBuilder {

    private String name;
    private String email;
    private String phone;
    private CustomerStatus status;
    private LocalDate dateOfBirth;
    private String address;
    private Card card;

    private CustomerBuilder() {
    }

    public static CustomerBuilder builder() {
        return new CustomerBuilder();
    }

    public CustomerBuilder withName(String name) {
        this.name = name;
        return this;
    }

    public CustomerBuilder withEmail(String email) {
        this.email = email;
        return this;
    }

    public CustomerBuilder withPhone(String phone) {
        this.phone = phone;
        return this;
    }

    public CustomerBuilder withStatus(CustomerStatus status) {
        this.status = status;
        return this;
    }

    public CustomerBuilder withDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
        return this;
    }

    public CustomerBuilder withAddress(String address) {
        this.address = address;
        return this;
    }

    public CustomerBuilder withCard(Card card) {
        this.card = card;
        return this;
    }

    public Customer build() {
        var customer = new Customer();
        customer.setName(name);
        customer.setEmail(email);
        customer.setPhone(phone);
        customer.setStatus(status);
        customer.setDateOfBirth(dateOfBirth);
        customer.setAddress(address);
        customer.setCard(card);

        return customer;
    }
}
