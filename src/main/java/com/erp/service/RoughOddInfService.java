package com.erp.service;

import com.erp.model.RoughOddInf;

import java.util.List;

public interface  RoughOddInfService {
    int selectRoughOddInfCount();

    List<RoughOddInf> selectApproveUser();

    int updateProcessInstanceIdRoughOddInf(RoughOddInf roughOddInf1);

    Boolean returnResult(String plainText);

    int updateStatusRoughOddInf(RoughOddInf roughOddInf);
}
