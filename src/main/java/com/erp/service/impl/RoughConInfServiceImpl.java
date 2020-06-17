package com.erp.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.erp.mapper.RoughConInfMapper;
import com.erp.model.RoughConInf;
import com.erp.model.RoughOrdInf;
import com.erp.service.RoughConInfService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class RoughConInfServiceImpl implements RoughConInfService {
    @Autowired
    private RoughConInfMapper roughConInfMapper;

    @Override
    public int selectRoughConInfCount() {
        return roughConInfMapper.selectRoughConInfCount();
    }

    @Override
    public List<RoughConInf> selectApproveUser() {
        return roughConInfMapper.selectApproveUser();
    }

    @Override
    public int updateProcessInstanceIdRoughConInf(RoughConInf roughConInf) {
        return roughConInfMapper.updateProcessInstanceIdRoughConInf(roughConInf);
    }

    @Override
    public int updateStatusRoughConInf(RoughConInf roughConInf) {
        return roughConInfMapper.updateStatusRoughConInf(roughConInf);
    }
    @Override
    public Boolean returnResult(String plainText) {
        JSONObject obj = JSON.parseObject(plainText);
        String processInstanceId=obj.getString("processInstanceId");
        if (obj.containsKey("result") && obj.getString("result").equals("agree")) {
            RoughConInf roughConInf = new RoughConInf();
            //数据库中该条数据审核状态变为审核通过
            roughConInf.setState("同意审核--坯布发货通知单");
            roughConInf.setProcessInstanceId(processInstanceId);
            int count = this.updateStatusRoughConInf(roughConInf);
            if (count > 0) {
                return true;
            } else {
                return false;
            }
        } else if (obj.containsKey("result") && obj.getString("result").equals("refuse")) {
            RoughConInf roughConInf = new RoughConInf();
            roughConInf.setState("拒绝审核--坯布发货通知单");
            roughConInf.setProcessInstanceId(processInstanceId);
            int count = this.updateStatusRoughConInf(roughConInf);
            if (count > 0) {
                return true;
            } else {
                return false;
            }
        }
        return false;
    }


}
