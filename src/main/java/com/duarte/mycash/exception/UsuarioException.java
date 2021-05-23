package com.duarte.mycash.exception;

public class UsuarioException extends RuntimeException {

    private static final long serialVersionUID = 8299765195065988622L;

    public UsuarioException() {
        super();
    }

    public UsuarioException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

    public UsuarioException(String message, Throwable cause) {
        super(message, cause);
    }

    public UsuarioException(String message) {
        super(message);
    }

    public UsuarioException(Throwable cause) {
        super(cause);
    }

}
