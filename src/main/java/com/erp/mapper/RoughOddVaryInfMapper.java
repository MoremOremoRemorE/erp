package com.erp.mapper;

import com.erp.model.RoughOddVaryInf;

import java.util.List;

public interface RoughOddVaryInfMapper {
    int selectRoughOddVaryInfCount();

    List<RoughOddVaryInf> selectApproveUser();

    int updateProcessInstanceIdRoughOddVaryInf(RoughOddVaryInf roughOddVaryInf);

    int updateStatusRoughOddVaryInf(RoughOddVaryInf roughOddVaryInf);
}
