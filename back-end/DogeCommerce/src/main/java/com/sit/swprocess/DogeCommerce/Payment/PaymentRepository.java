package com.sit.swprocess.DogeCommerce.Payment;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PaymentRepository extends JpaRepository<Payment, Long> {
    public Payment getById(String id);
}
