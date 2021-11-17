package com.dannio.blackjack.param.base;

import lombok.Builder;
import lombok.Data;


@Builder
public @Data class RestResponse<T> {

    private boolean success;

    private String message;

    private T data;

    public static <T>RestResponse<T> ok(T data) {
        return RestResponse.<T>builder()
                .success(true)
                .data(data)
                .build();
    }

    public static RestResponse<Void> ok() {
        return RestResponse.<Void>builder()
                .success(true)
                .build();
    }

    public static RestResponse<Void> fail(String message) {
        return RestResponse.<Void>builder()
                .success(false)
                .message(message)
                .build();

    }

}
