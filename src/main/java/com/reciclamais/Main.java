package com.reciclamais;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan("com.reciclamais")
@EnableJpaRepositories(basePackages = "com.reciclamais")
public class Main {
    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }


}