package com.projetPersos.ADM.exceptions;

public class AdmException extends Exception {
    private static final long serialVersionUID = 1L;

    protected AdmException(final String message) {
        super(message);
    }

    protected AdmException(final String message, final Throwable throwable) {
        super(message, throwable);
    }
}
