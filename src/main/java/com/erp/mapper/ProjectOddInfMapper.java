package com.erp.mapper;


import com.erp.model.ProjectOddInf;

import java.util.List;

public interface ProjectOddInfMapper {

    int selectProjectOddInfCount();

    List<ProjectOddInf> selectApproveUser();

    int updateProcessInstanceIdProjectOddInf(ProjectOddInf projectOddInf);

    int updateStatusProjectOddInf(ProjectOddInf projectOddInf);
}
