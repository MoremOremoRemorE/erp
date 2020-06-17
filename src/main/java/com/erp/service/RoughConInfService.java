package com.erp.service;


import com.erp.model.RoughConInf;

import java.util.List;

public interface RoughConInfService {

    int selectRoughConInfCount();

    List<RoughConInf> selectApproveUser();

    int updateProcessInstanceIdRoughConInf(RoughConInf roughConInf1);

    Boolean returnResult(String plainText);

    int updateStatusRoughConInf(RoughConInf roughConInf);
}
