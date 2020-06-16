package com.erp.service;

import com.alibaba.fastjson.JSONObject;
import com.erp.model.Test;

import java.util.List;

public interface TestService {
    int selectTestCount();

    List<Test> selectApproveTest();

    int updateProcessInstanceIdTest(Test test1);

    int updateStatusTest(Test test);

    Boolean returnResult(String  plainText);
}
