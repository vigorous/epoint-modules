package com.epoint.coupon.exception;

import com.epoint.exception.EpointException;

/**
 * Created by chiang on 2017/4/13.
 */
public class CouponException extends EpointException{
    public CouponException() {
        super();
    }

    public CouponException(String message) {
        super(message);
    }

    public CouponException(String message, Throwable cause) {
        super(message, cause);
    }

    public CouponException(Throwable cause) {
        super(cause);
    }

    protected CouponException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
