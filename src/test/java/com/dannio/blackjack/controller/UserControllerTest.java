package com.dannio.blackjack.controller;

import lombok.SneakyThrows;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class UserControllerTest {

    @Autowired
    private MockMvc mock;


    @Test
    @SneakyThrows
    void register() {
        String response = mock.perform(post("/user/register")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"name\":\"zhangsan\", \"password\":\"123456\"}")
        ).andExpect(status().isOk())
                .andReturn().getResponse().getContentAsString();
        assertNotNull(response);

        System.out.println("response:" + response);
    }
}