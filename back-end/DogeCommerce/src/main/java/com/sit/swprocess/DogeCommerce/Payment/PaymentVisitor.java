package com.sit.swprocess.DogeCommerce.Payment;

public interface PaymentVisitor<T> {
    T visitOmisePayment(OmisePayment omisePayment);
}