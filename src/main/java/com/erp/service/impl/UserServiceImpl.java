package com.erp.service.impl;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
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

    @Override
    public Boolean returnResult(String plainText) {
        JSONObject obj = JSON.parseObject(plainText);
        String processInstanceId=obj.getString("processInstanceId");
        if (obj.containsKey("result") && obj.getString("result").equals("agree")) {
            User user = new User();
            user.setStatus("同意审核");
            user.setProcessInstanceId(processInstanceId);
            int count = this.updateStatus(user);
            if(count>0){
               return true;
            }else {
                return false;
            }
        }else if(obj.containsKey("result") && obj.getString("result").equals("refuse")) {
            User user = new User();
            user.setStatus("拒绝审核");
            user.setProcessInstanceId(processInstanceId);
            int count = this.updateStatus(user);
            if (count > 0) {
                return true;
            } else {
                return false;
            }
        }
        return false;
    }

}
