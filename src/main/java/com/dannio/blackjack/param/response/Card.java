package com.dannio.blackjack.param.response;

import com.dannio.blackjack.param.base.Rest;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
public @Data class Card extends Rest {

    public String[] cards;

}
