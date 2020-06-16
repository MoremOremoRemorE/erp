package com.erp.mapper;


import com.erp.model.RoughOddInf;

import java.util.List;

public interface RoughOddInfMapper {
    int selectRoughOddInfCount();

    List<RoughOddInf> selectApproveUser();

    int updateProcessInstanceIdRoughOddInf(RoughOddInf roughOddInf);
}
