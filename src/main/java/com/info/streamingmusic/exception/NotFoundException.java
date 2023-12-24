package com.info.streamingmusic.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class NotFoundException extends RuntimeException {

    public NotFoundException() {
        super("Lo solicitado no se encuentra.");
    }

    public NotFoundException(String nombreDeRecurso, String nombreDeAtributo, String valorDeAtributo) {
        super(String.format("El recurso '%s' con %s '%s' no se encuentra.", nombreDeRecurso, nombreDeAtributo, valorDeAtributo));
    }

    public NotFoundException(String message) {
        super(message);
    }

    public NotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public NotFoundException(Throwable cause) {
        super(cause);
    }

    public NotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}