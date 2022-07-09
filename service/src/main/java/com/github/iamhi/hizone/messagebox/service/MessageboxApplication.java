package com.github.iamhi.hizone.messagebox.service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.data.r2dbc.repository.config.EnableR2dbcRepositories;

@SpringBootApplication(scanBasePackages = {"com.github.iamhi.hizone.messagebox"})
@ConfigurationPropertiesScan("com.github.iamhi.hizone.messagebox.config")
@EnableR2dbcRepositories(basePackages = {"com.github.iamhi.hizone.messagebox.out"})
public class MessageboxApplication {
    public static void main(String[] args) {
        SpringApplication.run(MessageboxApplication.class, args);
    }

}
