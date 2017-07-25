package com.epoint.order.exception;

import com.epoint.exception.EpointException;

/**
 * @author xishengchun on 2017-03-31.
 * 订单模块的异常
 */
public class OrderException extends EpointException {

    public OrderException() {
        super();
    }

    public OrderException(String message) {
        super(message);
    }

    public OrderException(String message, Throwable cause) {
        super(message, cause);
    }

    public OrderException(Throwable cause) {
        super(cause);
    }

    protected OrderException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
