package com.erp.model;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 *坯布采购变更单
 */
@Getter
@Setter
public class RoughOddVaryInf implements Serializable {

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
     * 经办人
     */
    private String emplName;
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
     * 明细内容
     *成品编码
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
     * 计价单位
     */
    private String jjUnitName;
    /**
     * 计价数量
     */
    private BigDecimal jjQty;
    /**
     * 单位
     */
    private String unitName;
    /**
     * 数量
     */
    private BigDecimal qty;
    /**
     * 交货日期
     */
    private String deliveryDT;
    /**
     * 备注
     */
    private String remarkC;
    /**
     * 变更计价数量
     */
    private BigDecimal jjQtyV;
    /**
     * 变更数量
     */
    private BigDecimal qtyV;
    /**
     * 变更件数
     */
    private BigDecimal pQtyV;
    /**
     * 变更时间
     */
    private String deliveryDTV;
    /**
     * 变更原因
     */
    private String varyReason;
    /**
     * 选择单号
     */
    private String barDh;



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
}
