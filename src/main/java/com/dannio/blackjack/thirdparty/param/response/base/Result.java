package com.dannio.blackjack.thirdparty.param.response.base;

import com.dannio.blackjack.thirdparty.param.response.ApiKey;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

public @Data class Result<T extends BaseResult> {

    private Integer code;

    private String msg;

    @JsonProperty("Key")
    private ApiKey key;

    private T data;

    public static final int SUCCESS = 0;

    public boolean isSuccess() {
        return code != null && this.code == SUCCESS;
    }

}
