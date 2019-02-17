package com.iru.dao;

public class DaoException extends RuntimeException {
    public static final long serialVersionUID = 1L;

    public DaoException(String message) {
        super(message);
    }

    public DaoException(Throwable cause) {
        super(cause);
    }

    public DaoException(String message, Throwable cause) {
        super(message, cause);
    }
}
