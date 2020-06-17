package com.erp.service;


import com.erp.model.MaterialOrdInf;

import java.util.List;

public interface MaterialOrdInfService {


    int selectMaterialOrdInfCount();

    List<MaterialOrdInf> selectApproveUser();

    int updateProcessInstanceIdMaterialOrdInf(MaterialOrdInf materialOrdInf1);

    Boolean returnResult(String plainText);

    int updateStatusMaterialOrdInf(MaterialOrdInf materialOrdInf);
}
