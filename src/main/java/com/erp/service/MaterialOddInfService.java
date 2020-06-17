package com.erp.service;


import com.erp.model.MaterialOddInf;
import com.erp.model.MaterialOrdInf;

import java.util.List;

public interface MaterialOddInfService {


    int selectMaterialOddInfCount();

    List<MaterialOddInf> selectApproveUser();

    int updateProcessInstanceIdMaterialOddInf(MaterialOddInf materialOddInf1);

    Boolean returnResult(String plainText);

    int updateStatusMaterialOddInf(MaterialOddInf materialOddInf);
}
