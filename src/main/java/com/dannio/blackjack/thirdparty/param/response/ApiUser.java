package com.dannio.blackjack.thirdparty.param.response;

import com.dannio.blackjack.thirdparty.param.response.base.BaseResult;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;


public @Data class ApiUser extends BaseResult {

    private String userCity;

    private Boolean userOnlineFlag;

    private Long userPoint;

    private String userAppRole;

    private String userIntro;

    private String userNo;

    private Long onlineMinute;

    @JsonProperty("userAvatarURL")
    private String userAvatarUrl;

    private String userNickname;

    @JsonProperty("oId")
    private String oid;

    private String userName;

    private String cardBg;

    private Integer followingUserCount;

    private String canFollow;

    private String userRole;

    private Integer followerCount;

    @JsonProperty("userURL")
    private String userUrl;
}
