package com.erp.model;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @author jcq
 * @date 2020/06/17
 * 付款审批单
 */
@Getter
@Setter
public class PaymentInf implements Serializable {

    /**
     * 唯一标识，数据库没有，这里暂时用id
     */
    private String id;
    /**
     * 目前需要的值，需要确认对方数据库是否存在
     */
    private String userId;
    private String userName;
    private Long deptId;
    private String processInstanceId;

    /**
     * 请款用途(目前缺失，需要确认)
     */
    private String xx;
    /**
     * 金额
     */
    private BigDecimal money;
    /**
     * 支付日期
     */
    private Date payDate;
    /**
     * 收款单位
     */
    private String payee;
    /**
     * 收款开户行
     */
    private String receivingBank;
    /**
     * 付款银行账号
     */
    private String payBankAccount;
    /**
     * 付款方式
     */
    private String payWay;
    /**
     * 图片(缺失)
     */
    private String picUrl;
    /**
     * 附件(缺失)
     */
    private String file;
    /**
     * 备注
     */
    private String remark;
    /**
     * 状态
     */
    private String state;
    /**
     * 部门id(原来c#项目中的)
     */
    private int deptID;



}
