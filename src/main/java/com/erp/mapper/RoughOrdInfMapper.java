package com.erp.mapper;

import com.erp.model.RoughOrdInf;

import java.util.List;

public interface RoughOrdInfMapper {
    /**
     * 查询坯布销售订单表中符合条件的数据
     * @return
     */
    int selectRoughOrdInfCount();

    List<RoughOrdInf> selectApproveUser();

    int updateProcessInstanceIdRoughOrdInf(RoughOrdInf roughOrdInf);

    int updateStatusRoughOrdInf(RoughOrdInf roughOrdInf);
}
