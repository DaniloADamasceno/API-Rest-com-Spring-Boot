package com.modulo24.service.exception;

import java.io.Serial;

@SuppressWarnings("Annotator")
public class ObjectNotFoundException extends RuntimeException {

    @Serial
    private static final long serialVersionUID = 1L;

    @SuppressWarnings("Annotator")
    public ObjectNotFoundException(String msg) {
        super(msg);
    }
}
