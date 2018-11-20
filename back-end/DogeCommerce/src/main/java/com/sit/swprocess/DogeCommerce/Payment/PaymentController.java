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
            chargeResult = omisePaymentService.chargeItem(token, order.getId(), omisePaymentService.calculatePriceForOmise(order));
            
            omisePayment.setLast4Digit(omisePaymentService.getLast4Digit(chargeResult.getChargeId()));
            omisePayment.setChargeId(chargeResult.getChargeId());
            omisePayment.setStatus("pending");
        } catch (Exception e) {
            e.printStackTrace();
            throw new ChargeException(e.getMessage());
        }
        order.setPayment(omisePayment);
        orderService.saveOrder(order);
        ResponseEntity<ChargeResult> response = new ResponseEntity<ChargeResult>(chargeResult, HttpStatus.CREATED);
        return response;
    }

    @GetMapping("/order/{order_id}/omise")
    public ResponseEntity<ChargeStatusResponse> getPaymentResponse(
            @PathVariable("order_id") long orderId
    ) throws IOException, OmiseException {
        Order order = orderService.getOrderByOrderId(orderId).get();
        long paymentId = order.getPayment().getId();
        OmisePayment omisePayment = omisePaymentService.getPaymentById(paymentId);
        boolean isPaid = omisePaymentService.isPaid(omisePayment.getChargeId());
        ChargeStatusResponse chargeStatusResponse = new ChargeStatusResponse();
        if(isPaid == true) {
            order.getPayment().setStatus("paid");
            orderService.saveOrder(order);
            chargeStatusResponse.setStatus("paid");
        } else {
            chargeStatusResponse.setStatus(order.getPayment().getStatus());
        }
        return new ResponseEntity<ChargeStatusResponse>(chargeStatusResponse, HttpStatus.OK);
    }
}
