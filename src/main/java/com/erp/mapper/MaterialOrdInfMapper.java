package com.erp.mapper;


import com.erp.model.MaterialOrdInf;

import java.util.List;

public interface MaterialOrdInfMapper {

    int selectMaterialOrdInfCount();

    List<MaterialOrdInf> selectApproveUser();

    int updateProcessInstanceIdMaterialOrdInf(MaterialOrdInf materialOrdInf);

    int updateStatusMaterialOrdInf(MaterialOrdInf materialOrdInf);
}
