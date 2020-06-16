package com.erp.service;


import com.erp.model.RoughOrdInf;

import java.util.List;

public interface RoughOrdInfService {
    /**
     * 查询坯布销售订单表中符合条件的数据
     * @return
     */
    int selectRoughOrdInfCount();

    List<RoughOrdInf> selectApproveUser();

    int updateProcessInstanceIdRoughOrdInf(RoughOrdInf roughOrdInf1);

    int updateStatusRoughOrdInf(RoughOrdInf roughOrdInf);

    Boolean returnResult(String plainText);
}
