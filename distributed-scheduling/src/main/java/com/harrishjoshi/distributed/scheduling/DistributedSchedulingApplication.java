package com.harrishjoshi.distributed.scheduling;

import com.harrishjoshi.distributed.scheduling.repository.CustomerRepository;
import com.harrishjoshi.distributed.scheduling.utils.CardUtils;
import com.harrishjoshi.distributed.scheduling.utils.CustomerUtils;
import jakarta.transaction.Transactional;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.transaction.support.TransactionTemplate;

@SpringBootApplication
public class DistributedSchedulingApplication {

    public static void main(String[] args) {
        SpringApplication.run(DistributedSchedulingApplication.class, args);
    }

    @Bean
    public ApplicationRunner applicationRunner(CustomerRepository customerRepository, TransactionTemplate transactionTemplate) {
        return args -> {
            var customerExists = customerRepository.count() > 0;
            if (!customerExists) {
                transactionTemplate.execute(status -> {
                    for (int i = 1; i <= 1000; i++) {
                        var customer = CustomerUtils.createCustomer(i);
                        customer.setCard(CardUtils.createCard(i, customer));
                        customerRepository.save(customer);
                    }

                    return null;
                });
            }
        };
    }
}
