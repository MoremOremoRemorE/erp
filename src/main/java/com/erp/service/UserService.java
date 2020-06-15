package com.erp.service;

import com.erp.model.User;

import java.util.List;

/**
 * 项目初期测试用
 */
public interface UserService {

    List<User> getList();

    List<User> selectApproveUser();

    int selectUserCount();

    int updateStatus(User user);

    int updateProcessInstanceId(User user1);
}
