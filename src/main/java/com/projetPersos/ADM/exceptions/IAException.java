package com.projetPersos.ADM.exceptions;

public class IAException extends AdmException{

    public IAException(final String message){
        super(message);
    }
    public IAException(final String message, final Throwable throwable) {
        super(message, throwable);
    }
}
