package com.dannio.blackjack.thirdparty.param.response;

import com.dannio.blackjack.thirdparty.param.response.base.BaseResult;
import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
public @Data class ApiKey extends BaseResult {

    private String key;

}
