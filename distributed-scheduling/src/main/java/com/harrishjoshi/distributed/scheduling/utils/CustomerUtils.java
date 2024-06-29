package com.harrishjoshi.distributed.scheduling.utils;

import com.harrishjoshi.distributed.scheduling.builder.CustomerBuilder;
import com.harrishjoshi.distributed.scheduling.entity.Customer;

import java.time.LocalDate;
import java.util.concurrent.ThreadLocalRandom;

import static com.harrishjoshi.distributed.scheduling.enums.CustomerStatus.ACTIVE;

public class CustomerUtils {

    public static Customer createCustomer(int index) {
        return CustomerBuilder.builder()
                .withName("Customer " + index)
                .withEmail("customer" + index + "@example.com")
                .withPhone("12345" + index)
                .withStatus(ACTIVE)
                .withDateOfBirth(generateDateOfBirth())
                .withAddress("Address " + index)
                .build();
    }

    /**
     * Generates a random date of birth ensuring the customer is at least 18 years old.
     *
     * @return a LocalDate representing the date of birth.
     */
    private static LocalDate generateDateOfBirth() {
        // Calculate the latest possible date of birth to be exactly 18 years ago from today
        LocalDate today = LocalDate.now();
        LocalDate latestDOB = today.minusYears(18);

        // Generated a random date of birth between 18 and 75 years ago
        LocalDate earliestDOB = today.minusYears(75);
        long minDay = earliestDOB.toEpochDay();
        long maxDay = latestDOB.toEpochDay();
        long randomDay = ThreadLocalRandom.current().nextLong(minDay, maxDay + 1);

        return LocalDate.ofEpochDay(randomDay);
    }
}
