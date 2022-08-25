package com.babbage.springbootwebstore;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBootWebStoreApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootWebStoreApplication.class, args);
        System.out.println("hello chuks");
    }

    @Override
    public void run(String... args) throws Exception {

    }
}
