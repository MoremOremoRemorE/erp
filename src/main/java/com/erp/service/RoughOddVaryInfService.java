package com.erp.service;

import com.erp.model.RoughOddVaryInf;
import com.erp.model.RoughOrdInf;

import java.util.List;

public interface RoughOddVaryInfService {
    int selectRoughOddVaryInfCount();

    List<RoughOddVaryInf> selectApproveUser();

    int updateProcessInstanceIdRoughOddVaryInf(RoughOddVaryInf roughOddVaryInf1);

    int updateStatusRoughOddVaryInf(RoughOddVaryInf roughOddVaryInf);

    Boolean returnResult(String plainText);
}
