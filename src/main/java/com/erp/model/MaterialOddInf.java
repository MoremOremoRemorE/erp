package com.erp.model;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @author jcq
 * @date 2020/06/17
 * 原料采购订单
 */
@Getter
@Setter
public class MaterialOddInf implements Serializable {

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
     * 客户名称
     */
    private String cltName;
    /**
     * 售价类型
     */
    private String sellSrtName;
    /**
     * 币种信息
     */
    private String currName;
    /**
     * 汇率
     */
    private BigDecimal excRate;
    /**
     *业务员
     */
    private String emplName;
    /**
     * 交货地址
     */
    private String deliveryAdd;
    /**
     * 包装方式
     */
    private String packModName;
    /**
     * 运输方式
     */
    private String trffcModName;
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
     * 原料编码
     */
    private String productCode;
    /**
     * 原料名称
     */
    private String productName;
    /**
     * 批号
     */
    private String batch;
    /**
     * 规格
     */
    private String spec;
    /**
     * 等级
     */
    private String leve;
    /**
     * 单位
     */
    private String unitName;
    /**
     * 数量
     */
    private BigDecimal qty;
    /**
     * 件数
     */
    private BigDecimal pQty;
    /**
     * 单价
     */
    private BigDecimal price;
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
