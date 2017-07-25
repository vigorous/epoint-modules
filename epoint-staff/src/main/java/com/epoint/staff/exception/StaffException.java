package com.epoint.staff.exception;

import com.epoint.exception.EpointException;

/**
 * package:com.epoint.staff.exception
 *
 * @Author smallc on 2017/6/2.
 */
public class StaffException extends EpointException {
    public StaffException() {
        super();
    }

    public StaffException(String message) {
        super(message);
    }

    public StaffException(String message, Throwable cause) {
        super(message, cause);
    }

    public StaffException(Throwable cause) {
        super(cause);
    }

    protected StaffException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
