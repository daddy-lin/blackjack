package com.dannio.blackjack.thirdparty;

import com.dannio.blackjack.thirdparty.param.UserApiParam;
import com.dannio.blackjack.thirdparty.param.response.ApiKey;
import com.dannio.blackjack.thirdparty.param.response.ApiUser;
import com.dannio.blackjack.thirdparty.param.response.base.Result;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import retrofit2.Response;

import static org.junit.jupiter.api.Assertions.*;

@Slf4j
@SpringBootTest
class ApiServiceTest {


    @Autowired
    private ApiService service;

    private UserApiParam user;
    private String apiKey;

    @BeforeEach
    public void setup() {
        user = UserApiParam.builder().nameOrEmail("dannio").userPassword("28ed8dc48145b6a36683945702b9d930").build();
        apiKey = "l9quk9pZlEGWorlePzeN5kI3ImgThjHJ";
    }

    @Test
    @SneakyThrows
    public void getKeyTest() {
        Response<Result<ApiKey>> response = service.getKey(user).execute();
        assertTrue(response.isSuccessful());
        assertNotNull(response.body());
        assertTrue(response.body().isSuccess());
        assertNotNull(response.body().getKey());
        log.info("apiKey:[{}]", response.body().getKey());
    }

    @Test
    @SneakyThrows
    public void getUserTest() {
        Response<Result<ApiUser>> response = service.getUser(apiKey).execute();
        assertTrue(response.isSuccessful());
        assertNotNull(response.body());
        assertTrue(response.body().isSuccess());
        assertNotNull(response.body().getData());
        log.info("apiUser[{}]", response.body().getData());
    }
}