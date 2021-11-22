package com.dannio.blackjack.service;

import com.dannio.blackjack.entry.User;
import com.dannio.blackjack.param.request.UserLoginParam;
import com.dannio.blackjack.repository.UserRepository;
import com.dannio.blackjack.thirdparty.ApiService;
import com.dannio.blackjack.thirdparty.RetrofitClient;
import com.dannio.blackjack.thirdparty.param.response.ApiKey;
import com.dannio.blackjack.thirdparty.param.response.ApiUser;
import com.dannio.blackjack.thirdparty.param.UserApiParam;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {


    @Autowired
    private UserRepository repository;

    @Autowired
    private ApiService apiService;


    @SneakyThrows
    public User login(UserLoginParam loginParam) {

        UserApiParam userApiParam = UserApiParam.builder()
                .nameOrEmail(loginParam.getUsername())
                .userPassword(loginParam.getPassword())
                .build();
        ApiKey apiKey = RetrofitClient.executeKey(apiService.getKey(userApiParam));

        ApiUser apiUser = RetrofitClient.execute(apiService.getUser(apiKey.getKey()));

        User user = repository.findByUsername(loginParam.getUsername());
        if (user == null) {
            user = User.builder()
                    .username(apiUser.getUserName())
                    .apiKey(apiKey.getKey())
                    .build();
        } else {
            user.setApiKey(apiKey.getKey());
        }
        return repository.save(user);
    }


}
