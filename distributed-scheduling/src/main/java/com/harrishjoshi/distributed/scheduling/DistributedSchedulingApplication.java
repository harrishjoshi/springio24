package com.harrishjoshi.distributed.scheduling;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class DistributedSchedulingApplication {

    public static void main(String[] args) {
        SpringApplication.run(DistributedSchedulingApplication.class, args);
    }
}
