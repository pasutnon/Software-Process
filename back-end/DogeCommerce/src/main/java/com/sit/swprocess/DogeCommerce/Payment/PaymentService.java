package com.sit.swprocess.DogeCommerce.Payment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaymentService {

    @Autowired
    PaymentRepository paymentRepository;

    public Payment getPaymentById(String paymentId) {
        return paymentRepository.getById(paymentId);
    }

    public List<Payment> getAllPayments() {
        return paymentRepository.findAll();
    }
}
