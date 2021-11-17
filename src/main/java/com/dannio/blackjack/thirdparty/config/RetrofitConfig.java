package com.dannio.blackjack.thirdparty.config;

import com.dannio.blackjack.thirdparty.ApiService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

@Configuration
public class RetrofitConfig {

    @Bean
    public Retrofit retrofit() {
        return new Retrofit.Builder()
                .baseUrl("https://pwl.icu/")
                .addConverterFactory(JacksonConverterFactory.create())
                .build();
    }


    @Bean
    public ApiService apiService() {
        return retrofit().create(ApiService.class);
    }

}

