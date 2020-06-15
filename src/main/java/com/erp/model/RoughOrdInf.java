package com.erp.model;


import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.math.BigDecimal;

@Getter
@Setter
/**
 * @author:jcq
 * 坯布销售订单
 */
public class RoughOrdInf implements Serializable {
    /**
     * 唯一标识，数据库没有，这里暂时用id
     */
    private String id;
    /**
     * 版本号
     */
    private BigDecimal version;
    /**
     * 单据编号
     */
    private String dh;
    /**
     * 制单日期
     */
    private String rq;
    /**
     * 客户名称
     */
    private String cltName;
    /**
     * 目标来源组织
     */
    private String toOrgName;
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
    private BigDecimal ExcRate;
    /**
     * 业务员
     */
    private String emplName;
    /**
     * 交货地址
     */
    private String deliveryAdd;
    /**
     * 运输方式
     */
    private String trffcModName;
    /**
     * 包装方式
     */
    private String packModName;
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
     * 明细字段
     * 成品编码
     */
    private String productCode;
    /**
     * 成品名称
     */
    private String productName;
    /**
     * 客户品名
     */
    private String proName;
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
     * 克重
     */
    private String faw;
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
     * 不含税单价
     */
    private BigDecimal taxprice;
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
     * 交货日期
     */
    private String deliveryDT;
    /**
     * 物料来源
     */
    private String matSource;
    /**
     * 备注
     */
    private String remarkC;

    /**
     * 目前需要的值，需要确认对方数据库是否存在
     */
    private String userId;
    private String userName;
    private Long deptId;
    private String processInstanceId;
}
