package com.projetPersos.ADM.exceptions;

public class Adm400Exception extends AdmException{
    public Adm400Exception(final String message) {
        super(message);
    }

    public Adm400Exception(final String message,final Throwable throwable) {
        super(message, throwable);
    }
}
