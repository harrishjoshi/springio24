package com.harrishjoshi.distributed.scheduling.repository;

import com.harrishjoshi.distributed.scheduling.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
