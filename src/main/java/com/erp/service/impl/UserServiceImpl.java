package com.erp.service.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.erp.mapper.UserMapper;
import com.erp.model.User;
import com.erp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * 测试用
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
    @Autowired
    private UserMapper userMapper;


    @Override
    @Cacheable(value="user",key="'userList'")
    public List<User> getList() {
        return userMapper.getList();
    }

    @Override
    public List<User> selectApproveUser() {
        return userMapper.selectApproveUser();
    }

    @Override
    public int selectUserCount() {
        return userMapper.selectUserCount();
    }

    @Override
    public int updateStatus(User user) {
        return userMapper.updateStatus(user);
    }

    @Override
    public int updateProcessInstanceId(User user) {
        return userMapper.updateProcessInstanceId(user);
    }

}
