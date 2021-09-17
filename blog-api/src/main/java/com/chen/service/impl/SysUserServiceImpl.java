package com.chen.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.chen.mapper.SysUserMapper;
import com.chen.pojo.SysUser;
import com.chen.service.LoginService;
import com.chen.service.SysUserService;
import com.chen.vo.ErrorCode;
import com.chen.vo.LoginUserVo;
import com.chen.vo.Result;
import com.chen.vo.UserVo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class SysUserServiceImpl implements SysUserService {
    @Autowired
    private SysUserMapper sysUserMapper;
    @Autowired
    private LoginService loginService;

    @Override
    public SysUser findSysUserById(Long id) {
        SysUser sysUser = sysUserMapper.selectById(id);
        if (sysUser==null){
            sysUser = new SysUser();
            sysUser.setNickname("陈俊杰");
        }
        return sysUser;
    }

    @Override
    public SysUser findUser(String account, String password) {
        LambdaQueryWrapper<SysUser> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(SysUser::getAccount,account);
        queryWrapper.eq(SysUser::getPassword,password);
        queryWrapper.select(SysUser::getId,SysUser::getAccount,SysUser::getAvatar,SysUser::getNickname);
        queryWrapper.last("limit 1");
        SysUser sysUser = sysUserMapper.selectOne(queryWrapper);
        return sysUser;
    }

    @Override
    public Result getUserInfoByToken(String token) {
        SysUser sysUser = loginService.checkToken(token);
        if (sysUser==null){
            return Result.fail(ErrorCode.TOKEN_ERROR.getCode(),ErrorCode.TOKEN_ERROR.getMsg());
        }
        LoginUserVo loginUserVo = new LoginUserVo();
        loginUserVo.setAccount(sysUser.getAccount());
        loginUserVo.setAvatar(sysUser.getAvatar());
        loginUserVo.setId(sysUser.getId());
        loginUserVo.setNickname(sysUser.getNickname());
        return Result.success(loginUserVo);
    }

    @Override
    public void save(SysUser sysUser) {
        sysUserMapper.insert(sysUser);
    }

    @Override
    public SysUser findUserByAccount(String account) {
        LambdaQueryWrapper<SysUser> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(SysUser::getAccount,account);
        queryWrapper.last("limit 1");
        return sysUserMapper.selectOne(queryWrapper);
    }

    @Override
    public UserVo findUserVoById(Long authorId) {
        SysUser sysUser = sysUserMapper.selectById(authorId);
        if (sysUser==null){
            sysUser = new SysUser();
            sysUser.setId(1L);
            sysUser.setAvatar("/static/img/logo.b3a48c0.png");
            sysUser.setNickname("陈俊杰");
        }
        UserVo userVo = new UserVo();
        BeanUtils.copyProperties(sysUser,userVo);
        return userVo;
    }
}
