package com.erp.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.erp.mapper.RoughOddInfMapper;
import com.erp.model.RoughConInf;
import com.erp.model.RoughOddInf;
import com.erp.service.RoughOddInfService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoughOddInfServiceImpl implements RoughOddInfService {
    @Autowired
    private RoughOddInfMapper roughOddInfMapper;
    @Override
    public int selectRoughOddInfCount() {
        return roughOddInfMapper.selectRoughOddInfCount();
    }

    @Override
    public List<RoughOddInf> selectApproveUser() {
        return roughOddInfMapper.selectApproveUser();
    }

    @Override
    public int updateProcessInstanceIdRoughOddInf(RoughOddInf roughOddInf) {
        return roughOddInfMapper.updateProcessInstanceIdRoughOddInf(roughOddInf);
    }

    @Override
    public int updateStatusRoughOddInf(RoughOddInf roughOddInf) {
        return roughOddInfMapper.updateStatusRoughOddInf(roughOddInf);
    }
    @Override
    public Boolean returnResult(String plainText) {
        JSONObject obj = JSON.parseObject(plainText);
        String processInstanceId=obj.getString("processInstanceId");
        if (obj.containsKey("result") && obj.getString("result").equals("agree")) {
            RoughOddInf roughOddInf = new RoughOddInf();
            //数据库中该条数据审核状态变为审核通过
            roughOddInf.setState("同意审核--坯布采购订单");
            roughOddInf.setProcessInstanceId(processInstanceId);
            int count = this.updateStatusRoughOddInf(roughOddInf);
            if (count > 0) {
                return true;
            } else {
                return false;
            }
        } else if (obj.containsKey("result") && obj.getString("result").equals("refuse")) {
            RoughOddInf roughOddInf = new RoughOddInf();
            roughOddInf.setState("拒绝审核--坯布采购订单");
            roughOddInf.setProcessInstanceId(processInstanceId);
            int count = this.updateStatusRoughOddInf(roughOddInf);
            if (count > 0) {
                return true;
            } else {
                return false;
            }
        }
        return false;
    }

}
