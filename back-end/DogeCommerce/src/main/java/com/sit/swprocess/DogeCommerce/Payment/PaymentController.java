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
@CrossOrigin
public class PaymentController {

    @Autowired
    OmisePaymentService omisePaymentService;

    @Autowired
    OrderService orderService;

    @GetMapping("")
    public List<OmisePayment> getAllPayments() {
        return omisePaymentService.getAllPayments();
    }

    @GetMapping("/{paymentId}")
    public Payment getPaymentById(@PathVariable long paymentId) {
        return omisePaymentService.getPaymentById(paymentId);
    }

    @PostMapping("/order/{order_id}/omise")
    public ResponseEntity<ChargeResult> createPayment(
            @RequestParam(required = true, name = "token") String token,
            @PathVariable("order_id") long orderId
    ) throws IOException, OmiseException {
        Order order = orderService.getOrderByOrderId(orderId).get();
        OmisePayment omisePayment = new OmisePayment();
        ChargeResult chargeResult;
        try {
            chargeResult = omisePaymentService.chargeOrder(token, order);
        } catch (Exception e) {
            throw new ChargeException(e.getMessage());
        }
        ResponseEntity<ChargeResult> response = new ResponseEntity<ChargeResult>(chargeResult, HttpStatus.CREATED);
        return response;
    }

    @GetMapping("/order/{order_id}/omise")
    public ResponseEntity<ChargeStatusResponse> getPaymentResponse(
            @PathVariable("order_id") long orderId
    ) throws IOException, OmiseException {
        Order order = orderService.getOrderByOrderId(orderId).get();
        ChargeStatusResponse chargeStatusResponse = omisePaymentService.checkAndUpdateStatus(order);
        return new ResponseEntity<ChargeStatusResponse>(chargeStatusResponse, HttpStatus.OK);
    }
}
