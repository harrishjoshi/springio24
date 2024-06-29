package com.harrishjoshi.distributed.scheduling.builder;

import com.harrishjoshi.distributed.scheduling.entity.Card;
import com.harrishjoshi.distributed.scheduling.entity.Customer;
import com.harrishjoshi.distributed.scheduling.enums.CardStatus;

import java.time.LocalDate;

public final class CardBuilder {

    private String cardType;
    private String cardNumber;
    private LocalDate expirationDate;
    private CardStatus status;
    private String cvv;
    private Customer customer;

    private CardBuilder() {
    }

    public static CardBuilder builder() {
        return new CardBuilder();
    }

    public CardBuilder withCardType(String cardType) {
        this.cardType = cardType;
        return this;
    }

    public CardBuilder withCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
        return this;
    }

    public CardBuilder withExpirationDate(LocalDate expirationDate) {
        this.expirationDate = expirationDate;
        return this;
    }

    public CardBuilder withStatus(CardStatus status) {
        this.status = status;
        return this;
    }

    public CardBuilder withCvv(String cvv) {
        this.cvv = cvv;
        return this;
    }

    public CardBuilder withCustomer(Customer customer) {
        this.customer = customer;
        return this;
    }

    public Card build() {
        var card = new Card();
        card.setCardNumber(cardNumber);
        card.setCardType(cardType);
        card.setExpirationDate(expirationDate);
        card.setStatus(status);
        card.setCvv(cvv);
        card.setCustomer(customer);

        return card;
    }
}
