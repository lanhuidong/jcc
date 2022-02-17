package com.nexusy.jcc.exception;

/**
 * @author lanhuidong
 * @since 2022-02-17
 */
public class ResourceNotFoundException extends RuntimeException {

    public ResourceNotFoundException(String message) {
        super(message);
    }

    public ResourceNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
