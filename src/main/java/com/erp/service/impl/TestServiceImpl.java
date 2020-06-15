package com.erp.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.erp.mapper.TestMapper;
import com.erp.mapper.UserMapper;
import com.erp.model.Test;
import com.erp.model.User;
import com.erp.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 也是测试用的
 */
@Service
public class TestServiceImpl extends ServiceImpl<UserMapper, User>  implements TestService {

    @Autowired
    private TestMapper testMapper;
    @Override
    public int selectTestCount() {
        return testMapper.selectTestCount();
    }

    @Override
    public List<Test> selectApproveTest() {
        return testMapper.selectApproveTest();
    }

    @Override
    public int updateProcessInstanceIdTest(Test test1) {
        return testMapper.updateProcessInstanceIdTest(test1);
    }

    @Override
    public int updateStatusTest(Test test) {
        return testMapper.updateStatusTest(test);
    }
}
