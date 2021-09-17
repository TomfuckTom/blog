package com.chen.controller;

import com.chen.service.LoginService;
import com.chen.vo.Result;
import com.chen.vo.params.LoginParams;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/login")
public class LoginController {
    @Autowired
    private LoginService loginService;


    @PostMapping
    public Result login(@RequestBody LoginParams loginParams){
        return loginService.login(loginParams);
    }
}
