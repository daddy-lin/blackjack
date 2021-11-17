package com.dannio.blackjack.controller;

import com.dannio.blackjack.entry.User;
import com.dannio.blackjack.param.base.RestResponse;
import com.dannio.blackjack.param.request.UserLoginParam;
import com.dannio.blackjack.service.UserService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/login")
public class LoginController {

    private final UserService userService;


    public LoginController(UserService userService){
        this.userService = userService;
    }


    @PostMapping("/sign-in")
    public RestResponse<Void> signIn(@RequestBody UserLoginParam userLogin, HttpServletResponse response){
        User user = userService.login(userLogin);

        Cookie cookie = new Cookie("__JACK_UID", Long.toHexString(user.getId().longValue()));
        response.addCookie(cookie);
        return RestResponse.ok();
    }


}
