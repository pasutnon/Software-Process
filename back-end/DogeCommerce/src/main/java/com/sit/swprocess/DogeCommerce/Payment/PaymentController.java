package com.sit.swprocess.DogeCommerce.Payment;

import co.omise.models.OmiseException;
import com.sit.swprocess.DogeCommerce.Order.Order;
import com.sit.swprocess.DogeCommerce.Order.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping(path = "/payments")
public class PaymentController {

    @Autowired
    PaymentService paymentService;

    @Autowired
    OrderService orderService;

    @GetMapping("")
    public List<Payment> getAllPayments() {
        return paymentService.getAllPayments();
    }

    @GetMapping("/{paymentId}")
    public Payment getPaymentById(@PathVariable String paymentId) {
        return paymentService.getPaymentById(paymentId);
    }

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
}
