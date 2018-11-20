package com.sit.swprocess.DogeCommerce.Payment;

import co.omise.Client;
import co.omise.ClientException;
import co.omise.models.Card;
import co.omise.models.Charge;
import co.omise.models.ChargeStatus;
import co.omise.models.OmiseException;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sit.swprocess.DogeCommerce.Order.Order;
import com.sit.swprocess.DogeCommerce.Order.OrderService;
import com.sit.swprocess.DogeCommerce.OrderDetail.OrderDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.text.DecimalFormat;
import java.util.List;

public class OmisePaymentService {

    @Autowired
    OmisePaymentRepository omisePaymentRepository;

    @Autowired
    DecimalFormat decimalFormat;

    @Autowired
    OrderService orderService;

    @Value("${frontend.url}")
    private String frontendURL;

    private Client omiseClient;

    public OmisePaymentService(String PUBLIC_KEY, String SECRET_KEY) throws ClientException {
        this.omiseClient = new Client(PUBLIC_KEY, SECRET_KEY);
    }

    public OmisePayment getPaymentById(long paymentId) {
        return omisePaymentRepository.findById(paymentId).get();
    }

    public List<OmisePayment> getAllPayments() {
        return omisePaymentRepository.findAll();
    }



    public ChargeResult chargeOrder(String token, Order order) throws IOException, OmiseException, ClientException {
        Charge.Create chargeSpec = new Charge.Create();

        chargeSpec
                .amount(this.calculatePrice(order))
                .currency("THB")
                .card(token)
                .returnUri(frontendURL + "order/" + order.getId() + "/payment/omise/complete");
        Charge charge = this.omiseClient.charges().create(chargeSpec);

        OmisePayment omisePayment = new OmisePayment();
        omisePayment.setLast4Digit(this.getLast4Digit(charge.getCard()));
        omisePayment.setChargeId(charge.getId());
        omisePayment.setStatus("pending");
        order.setPayment(omisePayment);
        orderService.saveOrder(order);

        ChargeResult chargeResult = new ChargeResult(charge.getId(), order.getId(), charge.getAuthorizeUri());
        return chargeResult;
    }

    public String getLast4Digit(Card card) throws OmiseException, IOException {
        return card.getLastDigits();
    }

    public Client getOmiseClient() {
        return omiseClient;
    }

    public long calculatePrice(Order order) {
        double price = 0;
        if (order.getOrderDetails() != null) {
            for(OrderDetail orderDetail: order.getOrderDetails()) {
                price += orderDetail.getQuantity() * orderDetail.getPriceEach();
            }
        }
        price += order.getShipment().getPrice();
        long calculatedPrice = Long.parseLong(this.decimalFormat.format(Math.floor(price))) * 100;
        return calculatedPrice;
    }

    public ChargeStatusResponse checkAndUpdateStatus(Order order) throws IOException, OmiseException {
        long paymentId = order.getPayment().getId();
        OmisePayment omisePayment = this.getPaymentById(paymentId);

        ChargeStatusResponse chargeStatusResponse = new ChargeStatusResponse();

        Charge charge = omiseClient.charges().get(omisePayment.getChargeId());
        if(charge.isPaid() == true) {
            order.getPayment().setStatus("paid");
            orderService.saveOrder(order);
            chargeStatusResponse.setStatus("paid");
        } else {
            chargeStatusResponse.setStatus(order.getPayment().getStatus());
        }
        return chargeStatusResponse;
    }
}
