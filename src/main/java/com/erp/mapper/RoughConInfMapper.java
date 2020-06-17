package com.erp.mapper;


import com.erp.model.RoughConInf;

import java.util.List;

public interface RoughConInfMapper {

    int selectRoughConInfCount();

    List<RoughConInf> selectApproveUser();

    int updateProcessInstanceIdRoughConInf(RoughConInf roughConInf);

    int updateStatusRoughConInf(RoughConInf roughConInf);
}
