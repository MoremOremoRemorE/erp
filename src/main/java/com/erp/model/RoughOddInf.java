package com.erp.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @author jcq
 * @date 2020/06/16
 * 坯布采购订单
 */
@Getter
@Setter
public class RoughOddInf implements Serializable {

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
     * 制单日期
     */
    private String Rq;
    /**
     * 供应商名称
     */
    private String cltName;
    /**
     * 售价类型
     */
    private String sellSrtName;
    /**
     * 币别信息
     */
    private String currName;
    /**
     * 汇率
     */
    private BigDecimal excRate;
    /**
     * 业务员
     */
    private String emplName;
    /**
     * 交货地址
     */
    private String deliveryAdd;
    /**
     * 制单人
     */
    private String crtoName;
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
     * 明细
     * 成品编码
     */
    private String productCode;
    /**
     * 成品名称
     */
    private String productName;
    /**
     * 供应商品
     */
    private String supplyName;
    /**
     *批号
     */
    private String  batch;
    /**
     * 规格
     */
    private String spec;
    /**
     * 等级
     */
    private String leve;
    /**
     * 计价单位
     */
    private String jjUnitName;
    /**
     * 计价数量
     */
    private BigDecimal jjQty;
    /**
     * 单价
     */
    private BigDecimal price;
    /**
     * 税率
     */
    private BigDecimal taxRate;
    /**
     * 金额
     */
    private BigDecimal money;
    /**
     * 数量
     */
    private BigDecimal qty;
    /**
     * 不含税单价
     */
    private BigDecimal taxPrice;
    /**
     * 税额
     */
    private BigDecimal taxMoney;
    /**
     * 不含税金额
     */
    private BigDecimal sumMoney;
    /**
     * 短交
     */
    private BigDecimal shortRate;
    /**
     * 超交
     */
    private BigDecimal beyondRate;
    /**
     * 交货日期
     */
    private String deliveryDT;
    /**
     * 备注
     */
    private String remarkC;


}
