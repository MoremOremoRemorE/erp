package com.erp.model;


import java.util.ArrayList;
import java.util.List;

public class UserMsg {
    public  static ProcessInstanceInputVO getProcessInstanceInputVO(User user) {
        ProcessInstanceInputVO processInstance = new ProcessInstanceInputVO();

        List<ProcessInstanceInputVO.TextForm> textForms = new ArrayList<>();
        processInstance.setDeptId(user.getDeptId());
        processInstance.setOriginatorUserId(user.getUserId());
        ProcessInstanceInputVO.TextForm textForm = new ProcessInstanceInputVO.TextForm();
        textForm.setName("[\\\"开始时间\\\",\\\"结束时间\\\"]");
        //处理时间控件的问题
        String time = user.getTime();
        String[] time1 = time.split(",");
        String time2 = "";
        time2 = "[\\\"" + time1[0] + "," + "\\\"" + time1[1] + "\\\"]";
        textForm.setValue(time2);

        ProcessInstanceInputVO.TextForm textForm1 = new ProcessInstanceInputVO.TextForm();
        textForm1.setName("出差人数");
        textForm1.setValue(user.getRenshu());

        ProcessInstanceInputVO.TextForm textForm2 = new ProcessInstanceInputVO.TextForm();
        textForm2.setName("出差金额");
        textForm2.setValue(user.getJine());

        ProcessInstanceInputVO.TextForm textForm3 = new ProcessInstanceInputVO.TextForm();
        textForm3.setName("出差同伴");
        textForm3.setValue(user.getTongban());

        ProcessInstanceInputVO.TextForm textForm4 = new ProcessInstanceInputVO.TextForm();
        textForm4.setName("交通工具");
        textForm4.setValue(user.getJttools());

        ProcessInstanceInputVO.TextForm textForm5 = new ProcessInstanceInputVO.TextForm();
        textForm5.setName("出差事由");
        textForm5.setValue(user.getCcshiyou());

        textForms.add(textForm);
        textForms.add(textForm1);
        textForms.add(textForm2);
        textForms.add(textForm3);
        textForms.add(textForm4);
        textForms.add(textForm5);

        processInstance.setTextForms(textForms);
        return processInstance;
    }
}
