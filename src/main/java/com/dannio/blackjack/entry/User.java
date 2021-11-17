package com.dannio.blackjack.entry;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;

import java.math.BigInteger;

@Builder
public @Data class User {

    @Id
    private BigInteger id;

    private String username;

    private String apiKey;

}
