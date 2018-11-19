package com.sit.swprocess.DogeCommerce.Bean;

import co.omise.ClientException;
import com.sit.swprocess.DogeCommerce.Payment.PaymentService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.text.DecimalFormat;

@Configuration
public class PaymentBean {
    @Value("${omise.secretkey}")
    private String SECRET_KEY;

    @Value("${omise.publickey}")
    private String PUBLIC_KEY;


    @Bean
    public PaymentService paymentService() throws ClientException {
        return new PaymentService(PUBLIC_KEY, SECRET_KEY);
    }

    @Bean
    public DecimalFormat decimalFormat() {
        return new DecimalFormat("##");
    }
}
