package com.projetPersos.ADM.exceptions;

public class Adm404Exception extends AdmException{
    public Adm404Exception(final String message) {
        super(message);
    }

    public Adm404Exception(final String message,final Throwable throwable) {
        super(message, throwable);
    }
}
