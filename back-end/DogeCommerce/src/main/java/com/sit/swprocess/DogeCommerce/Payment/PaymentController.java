package com.sit.swprocess.DogeCommerce.Payment;

import co.omise.Client;
import co.omise.ClientException;
import co.omise.models.Charge;
import co.omise.models.OmiseException;
import com.sit.swprocess.DogeCommerce.Order.Order;
import com.sit.swprocess.DogeCommerce.Order.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.nio.charset.CharacterCodingException;

@RestController
public class PaymentController {
    @Autowired
    PaymentService paymentService;

    @Autowired
    OrderService orderService;

    @PostMapping("/order/{order_id}/payment")
    public ResponseEntity<ChargeResult> createPayment(
            @RequestParam(required = true, name = "token") String token,
            @PathVariable("order_id") long orderId
    ) throws IOException, OmiseException {
        Order order = orderService.getOrderByOrderId(orderId).get();
        ChargeResult chargeResult;
        try {
            chargeResult = paymentService.chargeItem(token, order.getId(), order.getPriceForOmise());
        } catch (Exception e) {
            throw new ChargeException(e.getMessage());
        }
        ResponseEntity response = new ResponseEntity<ChargeResult>(chargeResult, HttpStatus.CREATED);
        return response;
    }

    @GetMapping("/order/{order_id}")
}
