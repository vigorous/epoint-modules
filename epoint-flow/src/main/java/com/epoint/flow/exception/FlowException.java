package com.epoint.flow.exception;

import com.epoint.exception.EpointException;

/**
 * @author xishengchun on 2017-05-18.
 */
public class FlowException extends EpointException {

    public FlowException() {
        super();
    }

    public FlowException(String message) {
        super(message);
    }

    public FlowException(String message, Throwable cause) {
        super(message, cause);
    }

    public FlowException(Throwable cause) {
        super(cause);
    }

    protected FlowException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
