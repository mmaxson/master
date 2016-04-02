package com.murun.addr.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Created by mark on 3/29/16.
 */

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "Address Not Found")
public class InternalErrorException extends RuntimeException {


    private static final long serialVersionUID = -3332292346834265371L;

    public InternalErrorException(Throwable e, String location, String message) {
        super("Internal Error:[" + location + "] " + message, e);
    }
}

