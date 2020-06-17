package com.erp.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.erp.mapper.PaymentInfMapper;
import com.erp.mapper.ProjectOddInfMapper;
import com.erp.model.PaymentInf;
import com.erp.model.ProjectOddInf;
import com.erp.service.PaymentInfService;
import com.erp.service.ProjectOddInfService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class PaymentInfServiceImpl implements PaymentInfService {
    @Autowired
    private PaymentInfMapper paymentInfMapper;


    @Override
    public int selectPaymentInfCount() {
        return paymentInfMapper.selectPaymentInfCount();
    }

    @Override
    public List<PaymentInf> selectApproveUser() {
        return paymentInfMapper.selectApproveUser();
    }

    @Override
    public int updateProcessInstanceIdPaymentInf(PaymentInf paymentInf) {
        return paymentInfMapper.updateProcessInstanceIdPaymentInf(paymentInf);
    }

    @Override
    public int updateStatusPaymentInf(PaymentInf paymentInf) {
        return paymentInfMapper.updateStatusPaymentInf(paymentInf);
    }

    @Override
    public Boolean returnResult(String plainText) {
        JSONObject obj = JSON.parseObject(plainText);
        String processInstanceId=obj.getString("processInstanceId");
        if (obj.containsKey("result") && obj.getString("result").equals("agree")) {
            PaymentInf paymentInf = new PaymentInf();
            //数据库中该条数据审核状态变为审核通过
            paymentInf.setState("同意审核--付款审批单");
            paymentInf.setProcessInstanceId(processInstanceId);
            int count = this.updateStatusPaymentInf(paymentInf);
            if (count > 0) {
                return true;
            } else {
                return false;
            }
        } else if (obj.containsKey("result") && obj.getString("result").equals("refuse")) {
            PaymentInf paymentInf = new PaymentInf();
            paymentInf.setState("拒绝审核--付款审批单");
            paymentInf.setProcessInstanceId(processInstanceId);
            int count = this.updateStatusPaymentInf(paymentInf);
            if (count > 0) {
                return true;
            } else {
                return false;
            }
        }
        return false;
    }


}
