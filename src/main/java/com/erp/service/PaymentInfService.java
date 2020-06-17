package com.erp.service;


import com.erp.model.PaymentInf;
import com.erp.model.ProjectOddInf;

import java.util.List;

public interface PaymentInfService {


    int selectPaymentInfCount();

    List<PaymentInf> selectApproveUser();

    int updateProcessInstanceIdPaymentInf(PaymentInf paymentInf1);

    Boolean returnResult(String plainText);

    int updateStatusPaymentInf(PaymentInf paymentInf);
}
