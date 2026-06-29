package com.ormlearn;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class OrmLearnApplication {
    public static void main(String[] args) {
        SpringApplication.run(OrmLearnApplication.class, args);
    }
}
