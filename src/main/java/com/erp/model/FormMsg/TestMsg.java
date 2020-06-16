package com.erp.model.FormMsg;


import com.erp.model.ProcessInstanceInputVO;
import com.erp.model.Test;

import java.util.ArrayList;
import java.util.List;

public class TestMsg {
    public static ProcessInstanceInputVO getProcessInstanceInputVOTest(Test test) {
        ProcessInstanceInputVO processInstance = new ProcessInstanceInputVO();

        List<ProcessInstanceInputVO.TextForm> textForms = new ArrayList<>();
        processInstance.setDeptId(test.getDeptId());
        processInstance.setOriginatorUserId(test.getUserId());
        ProcessInstanceInputVO.TextForm textForm = new ProcessInstanceInputVO.TextForm();
        textForm.setName("[\\\"开始时间\\\",\\\"结束时间\\\"]");
        //处理时间控件的问题
        String time = test.getTime();
        String[] time1 = time.split(",");
        String time2 = "";
        time2 = "[\\\"" + time1[0] + "," + "\\\"" + time1[1] + "\\\"]";
        textForm.setValue(time2);

        ProcessInstanceInputVO.TextForm textForm1 = new ProcessInstanceInputVO.TextForm();
        textForm1.setName("随便输");
        textForm1.setValue(test.getMessage());

        ProcessInstanceInputVO.TextForm textForm2 = new ProcessInstanceInputVO.TextForm();
        textForm2.setName("金额");
        textForm2.setValue(test.getMoney());

        textForms.add(textForm);
        textForms.add(textForm1);
        textForms.add(textForm2);

        processInstance.setTextForms(textForms);
        return processInstance;
    }
}
