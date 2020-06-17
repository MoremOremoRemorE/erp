package com.erp.mapper;


import com.erp.model.MaterialOddInf;
import com.erp.model.MaterialOrdInf;

import java.util.List;

public interface MaterialOddInfMapper {


    int selectMaterialOddInfCount();

    List<MaterialOddInf> selectApproveUser();

    int updateProcessInstanceIdMaterialOddInf(MaterialOddInf materialOddInf);

    int updateStatusMaterialOddInf(MaterialOddInf materialOddInf);
}
