package com.reservaservice.demo;

import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableRabbit
public class ReservaApplication {
    public static void main(String[] args) {
        SpringApplication.run(ReservaApplication.class, args);
    }
}