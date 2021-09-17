package com.chen.service;

import com.chen.pojo.SysUser;
import com.chen.vo.Result;
import com.chen.vo.params.LoginParams;

public interface LoginService {
    Result login(LoginParams loginParams);

    SysUser checkToken(String token);

    Result logout(String token);

    Result register(LoginParams loginParams);
}
