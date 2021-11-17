package com.dannio.blackjack.thirdparty.param;

import lombok.Builder;
import lombok.Data;

@Builder
public @Data class UserApiParam {

    private String nameOrEmail;

    private String userPassword;

}
