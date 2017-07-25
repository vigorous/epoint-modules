package com.epoint.reception.exception;

import com.epoint.exception.EpointException;

/**
 * @author xishengchun on 2017-05-24.
 */
public class ReceptionException extends EpointException {

    public ReceptionException() {
        super();
    }

    public ReceptionException(String message) {
        super(message);
    }

    public ReceptionException(String message, Throwable cause) {
        super(message, cause);
    }

    public ReceptionException(Throwable cause) {
        super(cause);
    }

    protected ReceptionException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
