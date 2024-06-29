package com.harrishjoshi.distributed.scheduling.job;

import com.harrishjoshi.distributed.scheduling.enums.CardStatus;
import com.harrishjoshi.distributed.scheduling.repository.CardRepository;
import com.harrishjoshi.distributed.scheduling.repository.CustomerRepository;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.transaction.support.TransactionTemplate;

import java.time.LocalDate;

import static com.harrishjoshi.distributed.scheduling.enums.CardStatus.EXPIRED;
import static com.harrishjoshi.distributed.scheduling.enums.CustomerStatus.DORMANT;


@Component
public class CardAndCustomerStatusJob {

    private final CustomerRepository customerRepository;
    private final CardRepository cardRepository;
    private final TransactionTemplate transactionTemplate;

    public CardAndCustomerStatusJob(CustomerRepository customerRepository, CardRepository cardRepository,
                                    TransactionTemplate transactionTemplate) {
        this.customerRepository = customerRepository;
        this.cardRepository = cardRepository;
        this.transactionTemplate = transactionTemplate;
    }

    @Scheduled(cron = "0 0 0 * * *")
    public void execute() {
        System.out.println("Executing Card and Customer Status Job");
        var pending = true;
        while (pending) {
            pending = Boolean.TRUE.equals(transactionTemplate.execute(status -> {
                var cards = cardRepository.findTop50ByStatusAndExpirationDateLessThanOrderByExpirationDateDesc(CardStatus.ACTIVE, LocalDate.now());
                if (cards.isEmpty()) {
                    return false;
                }

                cards.forEach(card -> {
                    card.setStatus(EXPIRED);

                    var customer = card.getCustomer();
                    customer.setStatus(DORMANT);
                    customerRepository.save(customer);
                });

                return true;
            }));
        }
    }
}
