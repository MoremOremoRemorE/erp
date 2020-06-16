package com.erp.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.erp.mapper.TestMapper;
import com.erp.mapper.UserMapper;
import com.erp.model.Test;
import com.erp.model.User;
import com.erp.service.TestService;
import com.erp.util.MessageUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

    @Override
    public Boolean returnResult(String plainText) {
        JSONObject obj = JSON.parseObject(plainText);
        String processInstanceId=obj.getString("processInstanceId");
           if (obj.containsKey("result") && obj.getString("result").equals("agree")) {
                Test test = new Test();
                test.setStatus("同意审核--TEST");
                test.setProcessInstanceId(processInstanceId);
                int count = this.updateStatusTest(test);
                if (count > 0) {
                    return true;
                } else {
                    return false;
                }
           } else if (obj.containsKey("result") && obj.getString("result").equals("refuse")) {
                Test test = new Test();
                test.setStatus("拒绝审核--TEST");
                test.setProcessInstanceId(processInstanceId);
                int count = this.updateStatusTest(test);
                if (count > 0) {
                    return true;
                } else {
                    return false;
                }
            }
        return false;
    }
}
