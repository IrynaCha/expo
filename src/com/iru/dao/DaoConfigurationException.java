package com.iru.dao;

public class DaoConfigurationException extends RuntimeException {
    public static final long serialVersionUID = 1L;

    public DaoConfigurationException(String message) {
        super(message);
    }

    public DaoConfigurationException(Throwable cause) {
        super(cause);
    }

    public DaoConfigurationException(String message, Throwable cause) {
        super(message, cause);
    }
}
