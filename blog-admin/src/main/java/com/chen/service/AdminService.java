package com.chen.service;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;

import com.chen.mapper.AdminMapper;
import com.chen.mapper.PermissionMapper;
import com.chen.pojo.Admin;
import com.chen.pojo.Permission;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminService {

    @Autowired
    private AdminMapper adminMapper;
    @Autowired
    private PermissionMapper permissionMapper;

    public Admin findAdminByUserName(String username){
        LambdaQueryWrapper<Admin> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(Admin::getUsername,username).last("limit 1");
        Admin admin = adminMapper.selectOne(queryWrapper);
        return admin;
    }

    public List<Permission> findPermissionsByAdminId(Long adminId){
        return permissionMapper.findPermissionsByAdminId(adminId);
    }

}
