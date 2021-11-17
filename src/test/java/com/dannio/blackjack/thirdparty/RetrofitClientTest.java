package com.dannio.blackjack.thirdparty;

import com.dannio.blackjack.thirdparty.param.UserApiParam;
import com.dannio.blackjack.thirdparty.param.response.ApiKey;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class RetrofitClientTest {

    @Autowired
    private ApiService service;

    private UserApiParam apiParam;

    @BeforeEach
    void setUp() {
        apiParam = UserApiParam.builder().nameOrEmail("dannio").userPassword("28ed8dc48145b6a36683945702b9d930").build();
    }

    @Test
    void executeKeyTest() {
        ApiKey apiKey = RetrofitClient.executeKey(service.getKey(apiParam));
        assertNotNull(apiKey);
        assertNotNull(apiKey.getKey());
    }
}