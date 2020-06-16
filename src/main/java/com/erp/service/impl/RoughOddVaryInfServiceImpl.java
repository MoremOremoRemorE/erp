package com.erp.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.erp.mapper.RoughOddVaryInfMapper;
import com.erp.model.RoughOddVaryInf;
import com.erp.model.RoughOrdInf;
import com.erp.service.RoughOddVaryInfService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoughOddVaryInfServiceImpl implements RoughOddVaryInfService {
    @Autowired
    private RoughOddVaryInfMapper roughOddVaryInfMapper;

    @Override
    public int selectRoughOddVaryInfCount() {
        return roughOddVaryInfMapper.selectRoughOddVaryInfCount();
    }

    @Override
    public List<RoughOddVaryInf> selectApproveUser() {
        return roughOddVaryInfMapper.selectApproveUser();
    }

    @Override
    public int updateProcessInstanceIdRoughOddVaryInf(RoughOddVaryInf roughOddVaryInf) {
        return roughOddVaryInfMapper.updateProcessInstanceIdRoughOddVaryInf(roughOddVaryInf);
    }

    @Override
    public int updateStatusRoughOddVaryInf(RoughOddVaryInf roughOddVaryInf) {
        return roughOddVaryInfMapper.updateStatusRoughOddVaryInf(roughOddVaryInf);
    }

    @Override
    public Boolean returnResult(String plainText) {
        JSONObject obj = JSON.parseObject(plainText);
        String processInstanceId=obj.getString("processInstanceId");
        if (obj.containsKey("result") && obj.getString("result").equals("agree")) {
            RoughOddVaryInf roughOddVaryInf = new RoughOddVaryInf();
            //数据库中该条数据审核状态变为审核通过
            roughOddVaryInf.setState("同意审核--坯布采购变更单");
            roughOddVaryInf.setProcessInstanceId(processInstanceId);
            int count = this.updateStatusRoughOddVaryInf(roughOddVaryInf);
            if (count > 0) {
                return true;
            } else {
                return false;
            }
        } else if (obj.containsKey("result") && obj.getString("result").equals("refuse")) {
            RoughOddVaryInf roughOddVaryInf = new RoughOddVaryInf();
            roughOddVaryInf.setState("拒绝审核--坯布采购变更单");
            roughOddVaryInf.setProcessInstanceId(processInstanceId);
            int count = this.updateStatusRoughOddVaryInf(roughOddVaryInf);
            if (count > 0) {
                return true;
            } else {
                return false;
            }
        }
        return false;
    }
}
