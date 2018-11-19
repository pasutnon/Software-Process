package com.sit.swprocess.DogeCommerce.Payment;

import co.omise.models.OmiseException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class ChargeException extends RuntimeException {
    public ChargeException() {
    }

    public ChargeException(String message) {
        super(message);
    }

    public ChargeException(String message, Throwable cause) {
        super(message, cause);
    }

    public ChargeException(Throwable cause) {
        super(cause);
    }

    public ChargeException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
