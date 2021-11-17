package com.dannio.blackjack.exception;

import lombok.Getter;

public class BlackException extends RuntimeException {

    @Getter
    private int coda;

    public BlackException() {
        super();
    }

    public BlackException(String message) {
        super(message);
    }


    public BlackException(int code, String message) {
        this(message);
        this.coda = code;
    }
}
