package com.rest.exception;

import lombok.Getter;

@Getter
public class RestException extends RuntimeException {
    private static final long serialVersionUID = -1166144997470374634L;
    private final int status;
    public RestException(String msg, int status) {
        super(msg);
        this.status = status;
    }
}
