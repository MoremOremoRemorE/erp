package com.erp.model;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @author jcq
 * @date 2020/06/17
 * 工程合同
 */
@Getter
@Setter
public class ProjectOddInf implements Serializable {

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
     * 订单号
     */
    private String cusDh;
    /**
     * 版本号
     */
    private BigDecimal version;
    /**
     * 单据编号
     */
    private String Dh;
    /**
     * 供应商名称
     */
    private String cltName;
    /**
     * 制单日期
     */
    private String Rq;
    /**
     * 业务员名称
     */
    private String emplName;
    /**
     * 币别信息
     */
    private String currName;
    /**
     * 汇率
     */
    private BigDecimal excRate;
    /**
     * 业务员(这个字段需要确认）
     */
    private String emplName1;
    /**
     * 交货地址
     */
    private String deliveryAdd;
    /**
     * 制单人
     */
    private String crtorName;
    /**
     * 制单时间
     */
    private String crtorDT;
    /**
     * 修改人
     */
    private String mdferName;
    /**
     * 修改时间
     */
    private String mdfDT;
    /**
     * 单据状态
     */
    private String state;
    /**
     * 备注
     */
    private String remark;
    /**
     * 明细部分
     * 项目
     */
    private String spec;
    /**
     * 单位
     */
    private String unitName;
    /**
     * 数量
     */
    private BigDecimal qty;
    /**
     * 税率
     */
    private BigDecimal taxRate;
    /**
     * 不含税单价
     */
    private BigDecimal taxPrice;
    /**
     * 金额
     */
    private BigDecimal money;
    /**
     * 预付款比
     */
    private BigDecimal yfRate;
    /**
     * 预付款
     */
    private BigDecimal yfMoney;
    /**
     * 后付款金
     */
    private BigDecimal hfkMoney;
    /**
     * 税额
     */
    private BigDecimal taxMoney;
    /**
     * 不含税金额
     */
    private BigDecimal sumMoney;
    /**
     * 交货日期
     */
    private String deliveryDT;
    /**
     * 备注
     */
    private String remarkC;
    /**
     * 选择单号
     */
    private String barDh;
    /**
     * 业务状态
     */
    private String useStageC;



}
