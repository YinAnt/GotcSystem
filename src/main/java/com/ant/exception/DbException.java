package com.ant.exception;

public class DbException extends Exception{

    public DbException() {
        super();
    }

    public DbException(String detailMessage, Throwable throwable) {
        super(detailMessage, throwable);
    }

    public DbException(String detailMessage) {
        super(detailMessage);
    }

    public DbException(Throwable throwable) {
        super(throwable);
    }
}
