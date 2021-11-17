package com.dannio.blackjack.thirdparty;

import com.dannio.blackjack.thirdparty.param.UserApiParam;
import com.dannio.blackjack.thirdparty.param.response.ApiKey;
import com.dannio.blackjack.thirdparty.param.response.ApiUser;
import com.dannio.blackjack.thirdparty.param.response.base.Result;
import retrofit2.Call;
import retrofit2.http.*;

public interface ApiService {

    @POST("/api/getKey")
    Call<Result<ApiKey>> getKey(@Body UserApiParam param);

    @GET("/api/user")
    Call<Result<ApiUser>> getUser(@Query("apiKey") String apiKey);

    @GET("user/{username}")
    Call<Object> getUserByName(@Path("username")String username);

}
