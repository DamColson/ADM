package com.projetPersos.ADM.exceptions;

public class Adm500Exception extends AdmException{
    public Adm500Exception(final String message) {
        super(message);
    }

    public Adm500Exception(final String message,final Throwable throwable) {
        super(message, throwable);
    }
}
