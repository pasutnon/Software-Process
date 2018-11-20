package com.sit.swprocess.DogeCommerce;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class DogeCommerceApplication {

	public static void main(String[] args) {
		SpringApplication.run(DogeCommerceApplication.class, args);
	}
}
