package com.chen.service;

import com.chen.pojo.SysUser;
import com.chen.vo.Result;
import com.chen.vo.UserVo;

public interface SysUserService {
    SysUser findSysUserById(Long id);

    SysUser findUser(String account, String password);

    Result getUserInfoByToken(String token);

    void save(SysUser sysUser);

    SysUser findUserByAccount(String account);

    UserVo findUserVoById(Long authorId);
}
