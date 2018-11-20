package com.sit.swprocess.DogeCommerce.Payment;

import co.omise.Client;
import co.omise.ClientException;
import co.omise.models.Charge;
import co.omise.models.OmiseException;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sit.swprocess.DogeCommerce.Order.Order;
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

    @Value("${frontend.url}")
    private String frontendURL;

    private Client omiseClient;

    public OmisePayment getPaymentById(long paymentId) {
        return omisePaymentRepository.findById(paymentId).get();
    }

    public List<OmisePayment> getAllPayments() {
        return omisePaymentRepository.findAll();
    }

    public OmisePaymentService(String PUBLIC_KEY, String SECRET_KEY) throws ClientException {
        this.omiseClient = new Client(PUBLIC_KEY, SECRET_KEY);
    }

    public ChargeResult chargeItem(String token, long orderId, long price) throws IOException, OmiseException, ClientException {
        Charge.Create chargeSpec = new Charge.Create();
        chargeSpec
                .amount(price)
                .currency("THB")
                .card(token)
                .returnUri(frontendURL + "order/" + orderId + "/payment/omise/complete");
        Charge charge = this.omiseClient.charges().create(chargeSpec);
        ChargeResult chargeResult = new ChargeResult(charge.getId(), orderId, charge.getAuthorizeUri());
        return chargeResult;
    }

    public String getLast4Digit(String chargeToken) throws OmiseException, IOException {
        return omiseClient.charges().get(chargeToken).getCard().getLastDigits();
    }

    public Client getOmiseClient() {
        return omiseClient;
    }

    public boolean isPaid(String chargeId) throws IOException, OmiseException {
        return omiseClient.charges().get(chargeId).isPaid();
    }

    public long calculatePriceForOmise(Order order) {
        long price = 0;
        if (order.getOrderDetails() != null) {
            for(OrderDetail orderDetail: order.getOrderDetails()) {
                price += Long.parseLong(this.decimalFormat.format(orderDetail.getQuantity() * orderDetail.getPriceEach() * 100));
            }
        }
        return price;
    }
}
