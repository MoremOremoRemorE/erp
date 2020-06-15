package com.erp.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.erp.model.User;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 仅供搭建项目初期测试
 */
@Repository
public interface UserMapper extends BaseMapper<User> {


    /**
     * 用户列表 测试用
     */
    List<User> getList();

    List<User> selectApproveUser();

    int selectUserCount();

    int updateStatus(User user);

    int updateProcessInstanceId(User user);
}
