package com.dannio.blackjack.thirdparty;

import com.dannio.blackjack.exception.BlackException;
import com.dannio.blackjack.thirdparty.param.response.ApiKey;
import com.dannio.blackjack.thirdparty.param.response.base.BaseResult;
import com.dannio.blackjack.thirdparty.param.response.base.Result;
import lombok.SneakyThrows;
import retrofit2.Call;
import retrofit2.Response;

public class RetrofitClient {


    @SneakyThrows
    public static <T extends BaseResult> T execute(Call<Result<T>> instance) {
        return executeBody(instance).getData();
    }


    @SneakyThrows
    public static <T extends BaseResult> ApiKey executeKey(Call<Result<T>> instance) {
        return executeBody(instance).getKey();
    }


    @SneakyThrows
    private static <T extends BaseResult> Result<T> executeBody(Call<Result<T>> instance) {
        Response<Result<T>> response = instance.execute();
        if (!response.isSuccessful() || response.body() == null) {
            throw new BlackException("api execute fail");
        }
        if (!response.body().isSuccess()) {
            throw new BlackException(response.body().getCode(), response.body().getMsg());
        }
        return response.body();
    }

}
