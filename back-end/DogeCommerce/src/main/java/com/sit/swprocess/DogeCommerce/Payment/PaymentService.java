package com.sit.swprocess.DogeCommerce.Payment;

import co.omise.Client;
import co.omise.ClientException;
import co.omise.models.Charge;
import co.omise.models.OmiseException;
import com.sit.swprocess.DogeCommerce.Order.Order;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import sun.awt.image.PNGImageDecoder;

import java.io.IOException;

public class PaymentService {

    @Value("${frontend.url}")
    private String frontendURL;


    private Client omiseClient;

    public PaymentService(String PUBLIC_KEY, String SECRET_KEY) throws ClientException {
        this.omiseClient = new Client(PUBLIC_KEY, SECRET_KEY);
    }

    public ChargeResult chargeItem(String token, long orderId, long price) throws IOException, OmiseException, ClientException {
        Charge.Create chargeSpec = new Charge.Create();
        chargeSpec
                .amount(price)
                .currency("THB")
                .card(token)
                .returnUri(frontendURL + "order/" + orderId + "/payment/complete");
        Charge charge = this.omiseClient.charges().create(chargeSpec);
        ChargeResult chargeResult = new ChargeResult(charge.getId(), orderId, charge.getAuthorizeUri());
        return chargeResult;
    }

    public Client getOmiseClient() {
        return omiseClient;
    }
}
