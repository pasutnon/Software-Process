package com.sit.swprocess.DogeCommerce.Payment;

import java.io.Serializable;

public class ChargeStatusResponse implements Serializable {
    private String status;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
