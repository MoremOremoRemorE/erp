package com.erp.service;


import com.erp.model.ProjectOddInf;

import java.util.List;

public interface ProjectOddInfService {

    int selectProjectOddInfCount();

    List<ProjectOddInf> selectApproveUser();

    int updateProcessInstanceIdProjectOddInf(ProjectOddInf projectOddInf);

    Boolean returnResult(String plainText);

    int updateStatusProjectOddInf(ProjectOddInf projectOddInf);
}
