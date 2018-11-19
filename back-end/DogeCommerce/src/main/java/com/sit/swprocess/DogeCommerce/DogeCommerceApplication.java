package com.sit.swprocess.DogeCommerce;

import co.omise.ClientException;
import com.sit.swprocess.DogeCommerce.Payment.PaymentService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.text.DecimalFormat;

@SpringBootApplication
@EnableJpaAuditing
public class DogeCommerceApplication {

	public static void main(String[] args) {
		SpringApplication.run(DogeCommerceApplication.class, args);
	}
}
