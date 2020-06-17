package com.erp.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.erp.mapper.ProjectOddInfMapper;
import com.erp.model.ProjectOddInf;
import com.erp.service.ProjectOddInfService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ProjectOddInfServiceImpl implements ProjectOddInfService {
    @Autowired
    private ProjectOddInfMapper projectOddInfMapper;


    @Override
    public int selectProjectOddInfCount() {
        return projectOddInfMapper.selectProjectOddInfCount();
    }

    @Override
    public List<ProjectOddInf> selectApproveUser() {
        return projectOddInfMapper.selectApproveUser();
    }

    @Override
    public int updateProcessInstanceIdProjectOddInf(ProjectOddInf projectOddInf) {
        return projectOddInfMapper.updateProcessInstanceIdProjectOddInf(projectOddInf);
    }

    @Override
    public int updateStatusProjectOddInf(ProjectOddInf projectOddInf) {
        return projectOddInfMapper.updateStatusProjectOddInf(projectOddInf);
    }
    @Override
    public Boolean returnResult(String plainText) {
        JSONObject obj = JSON.parseObject(plainText);
        String processInstanceId=obj.getString("processInstanceId");
        if (obj.containsKey("result") && obj.getString("result").equals("agree")) {
            ProjectOddInf projectOddInf = new ProjectOddInf();
            //数据库中该条数据审核状态变为审核通过
            projectOddInf.setState("同意审核--工程合同");
            projectOddInf.setProcessInstanceId(processInstanceId);
            int count = this.updateStatusProjectOddInf(projectOddInf);
            if (count > 0) {
                return true;
            } else {
                return false;
            }
        } else if (obj.containsKey("result") && obj.getString("result").equals("refuse")) {
            ProjectOddInf projectOddInf = new ProjectOddInf();
            projectOddInf.setState("拒绝审核--工程合同");
            projectOddInf.setProcessInstanceId(processInstanceId);
            int count = this.updateStatusProjectOddInf(projectOddInf);
            if (count > 0) {
                return true;
            } else {
                return false;
            }
        }
        return false;
    }
}
