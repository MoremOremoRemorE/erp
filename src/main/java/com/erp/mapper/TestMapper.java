package com.erp.mapper;

import com.erp.model.Test;

import java.util.List;

public interface TestMapper {
    int selectTestCount();

    List<Test> selectApproveTest();

    int updateProcessInstanceIdTest(Test test1);

    int updateStatusTest(Test test);
}
