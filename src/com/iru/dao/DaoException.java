package com.iru.dao;

@SuppressWarnings("serial")
public class DaoException extends Exception {

    public DaoException() {
    }

    public DaoException(String message, Throwable cause) {
        super(message, cause);
    }
}
