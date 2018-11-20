package com.sit.swprocess.DogeCommerce.Payment;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

@Entity
@DiscriminatorValue(value="true")
public class OmisePayment extends Payment implements Serializable {

    @NotNull
    private String last4Digit;

    @NotNull
    private String chargeId;

    public OmisePayment(){}

    public OmisePayment(@NotNull String last4Digit) {
        this.last4Digit = last4Digit;
    }

    public OmisePayment(long id, @NotNull String status, Date createAt, Date updateAt, @NotNull String last4Digit) {
        super(id, status, createAt, updateAt);
        this.last4Digit = last4Digit;
    }

    public String getLast4Digit() {
        return last4Digit;
    }

    public void setLast4Digit(String last4Digit) {
        this.last4Digit = last4Digit;
    }

    public String getChargeId() {
        return chargeId;
    }

    public void setChargeId(String chargeId) {
        this.chargeId = chargeId;
    }


}
