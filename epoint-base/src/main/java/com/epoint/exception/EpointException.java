package com.epoint.exception;

/**
 * Created by chiang on 2017/4/7.
 */
public class EpointException extends RuntimeException{

    public EpointException() {
        super();
    }

    public EpointException(String message) {
        super(message);
    }

    public EpointException(String message, Throwable cause) {
        super(message, cause);
    }

    public EpointException(Throwable cause) {
        super(cause);
    }

    protected EpointException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
