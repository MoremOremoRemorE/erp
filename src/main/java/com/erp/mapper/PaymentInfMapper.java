package com.erp.mapper;


import com.erp.model.PaymentInf;

import java.util.List;

public interface PaymentInfMapper {


    int selectPaymentInfCount();

    List<PaymentInf> selectApproveUser();

    int updateProcessInstanceIdPaymentInf(PaymentInf paymentInf);

    int updateStatusPaymentInf(PaymentInf paymentInf);
}
