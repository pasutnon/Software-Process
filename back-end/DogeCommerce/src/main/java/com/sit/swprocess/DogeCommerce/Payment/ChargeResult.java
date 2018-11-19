package com.sit.swprocess.DogeCommerce.Payment;

import java.io.Serializable;

public class ChargeResult implements Serializable {
    private String chargeId;
    private long orderId;
    private String authorizedUrl;

    public ChargeResult(String chargeId, long orderId, String authorizedUrl) {
        this.chargeId = chargeId;
        this.orderId = orderId;
        this.authorizedUrl = authorizedUrl;
    }

    public String getChargeId() {
        return chargeId;
    }

    public void setChargeId(String chargeId) {
        this.chargeId = chargeId;
    }

    public long getOrderId() {
        return orderId;
    }

    public void setOrderId(long orderId) {
        this.orderId = orderId;
    }

    public String getAuthorizedUrl() {
        return authorizedUrl;
    }

    public void setAuthorizedUrl(String authorizedUrl) {
        this.authorizedUrl = authorizedUrl;
    }
}
