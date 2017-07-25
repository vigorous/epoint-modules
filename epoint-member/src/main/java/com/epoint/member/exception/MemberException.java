package com.epoint.member.exception;

import com.epoint.exception.EpointException;

/**
 * package:com.epoint.member.exception
 *
 * @Author smallc on 2017/5/23.
 */
public class MemberException extends EpointException {
    public MemberException() {
        super();
    }

    public MemberException(String message) {
        super(message);
    }

    public MemberException(String message, Throwable cause) {
        super(message, cause);
    }

    public MemberException(Throwable cause) {
        super(cause);
    }

    protected MemberException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
