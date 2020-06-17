package com.erp.model;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @author jcq
 * @date 2020/06/17
 * 坯布发货通知单
 */
@Getter
@Setter
public class RoughConInf implements Serializable {

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
     * 业务员
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
     * 明细部分
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
     * 板号
     */
    private String roPrmtr4;
    /**
     * 幅宽
     */
    private String roPrmtr2;
    /**
     * 轴号
     */
    private String roPrmtr3;
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
    private BigDecimal qty2;
    /**
     * 税率
     */
    private BigDecimal taxRate;
    /**
     * 单价
     */
    private BigDecimal price;
    /**
     * 选择单号
     */
    private String barDh;
    /**
     * 备注
     */
    private String remarkC;



}
