package com.dannio.blackjack.param.request;

import lombok.Data;

public @Data class UserLoginParam {

    private String username;

    private String password;

    private boolean remember;

}
