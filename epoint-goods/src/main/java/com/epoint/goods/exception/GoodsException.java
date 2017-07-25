package com.epoint.goods.exception;

import com.epoint.exception.EpointException;

/**
 * package:com.epoint.goods.exception
 *
 * @Author smallc on 2017/6/5.
 */
public class GoodsException extends EpointException {
    public GoodsException() {
        super();
    }

    public GoodsException(String message) {
        super(message);
    }

    public GoodsException(String message, Throwable cause) {
        super(message, cause);
    }

    public GoodsException(Throwable cause) {
        super(cause);
    }

    protected GoodsException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
