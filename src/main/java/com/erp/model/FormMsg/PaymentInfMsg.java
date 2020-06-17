package com.erp.model.FormMsg;

import com.erp.model.PaymentInf;
import com.erp.model.ProcessInstanceInputVO;
import com.erp.model.ProjectOddInf;
import com.erp.util.DateUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * 付款审批单
 */
public class PaymentInfMsg {

    public static ProcessInstanceInputVO getProcessInstanceInputVOPaymentInf(PaymentInf paymentInf) {
        ProcessInstanceInputVO processInstance = new ProcessInstanceInputVO();

        List<ProcessInstanceInputVO.TextForm> textForms = new ArrayList<>();
        //审核人部门id
        processInstance.setDeptId(paymentInf.getDeptId());
        //审核发起人userid
        processInstance.setOriginatorUserId(paymentInf.getUserId());

        ProcessInstanceInputVO.TextForm textForm = new ProcessInstanceInputVO.TextForm();
        textForm.setName("请款用途");
        textForm.setValue(paymentInf.getXx());

        ProcessInstanceInputVO.TextForm textForm1 = new ProcessInstanceInputVO.TextForm();
        textForm1.setName("金额");
        textForm1.setValue(paymentInf.getMoney().toString());

        ProcessInstanceInputVO.TextForm textForm2 = new ProcessInstanceInputVO.TextForm();
        textForm2.setName("支付日期");
        textForm2.setValue(DateUtil.dateToString(paymentInf.getPayDate()));

        ProcessInstanceInputVO.TextForm textForm3 = new ProcessInstanceInputVO.TextForm();
        textForm3.setName("收款单位");
        textForm3.setValue(paymentInf.getPayee());

        ProcessInstanceInputVO.TextForm textForm4 = new ProcessInstanceInputVO.TextForm();
        textForm4.setName("收款开户行");
        textForm4.setValue(paymentInf.getReceivingBank());

        ProcessInstanceInputVO.TextForm textForm5 = new ProcessInstanceInputVO.TextForm();
        textForm5.setName("付款银行账户");
        textForm5.setValue(paymentInf.getPayBankAccount());

        ProcessInstanceInputVO.TextForm textForm6 = new ProcessInstanceInputVO.TextForm();
        textForm6.setName("付款方式");
        textForm6.setValue(paymentInf.getPayWay());

        ProcessInstanceInputVO.TextForm textForm7 = new ProcessInstanceInputVO.TextForm();
        textForm7.setName("图片");
        textForm7.setValue(paymentInf.getPicUrl());

        ProcessInstanceInputVO.TextForm textForm8 = new ProcessInstanceInputVO.TextForm();
        textForm8.setName("附件");
        textForm8.setValue(paymentInf.getFile());

		/*textForm.setName("[\\\"开始时间\\\",\\\"结束时间\\\"]");
		//处理时间控件的问题
		String time = test.getTime();
		String[] time1 = time.split(",");
		String time2 = "";
		time2 = "[\\\"" + time1[0] + "," + "\\\"" + time1[1] + "\\\"]";
		textForm.setValue(time2);*/

        textForms.add(textForm);
        textForms.add(textForm1);
        textForms.add(textForm2);
        textForms.add(textForm3);
        textForms.add(textForm4);
        textForms.add(textForm5);
        textForms.add(textForm6);
        textForms.add(textForm7);
        textForms.add(textForm8);

        processInstance.setTextForms(textForms);
        return processInstance;
    }


}
