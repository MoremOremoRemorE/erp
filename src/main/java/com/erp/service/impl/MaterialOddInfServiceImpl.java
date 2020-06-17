package com.erp.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.erp.mapper.MaterialOddInfMapper;
import com.erp.mapper.MaterialOrdInfMapper;
import com.erp.model.MaterialOddInf;
import com.erp.model.MaterialOrdInf;
import com.erp.service.MaterialOddInfService;
import com.erp.service.MaterialOrdInfService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class MaterialOddInfServiceImpl implements MaterialOddInfService {
    @Autowired
    private MaterialOddInfMapper materialOddInfMapper;


    @Override
    public int selectMaterialOddInfCount() {
        return materialOddInfMapper.selectMaterialOddInfCount();
    }

    @Override
    public List<MaterialOddInf> selectApproveUser() {
        return materialOddInfMapper.selectApproveUser();
    }

    @Override
    public int updateProcessInstanceIdMaterialOddInf(MaterialOddInf materialOddInf) {
        return materialOddInfMapper.updateProcessInstanceIdMaterialOddInf(materialOddInf);
    }

    @Override
    public int updateStatusMaterialOddInf(MaterialOddInf materialOddInf) {
        return materialOddInfMapper.updateStatusMaterialOddInf(materialOddInf);
    }
    @Override
    public Boolean returnResult(String plainText) {
        JSONObject obj = JSON.parseObject(plainText);
        String processInstanceId=obj.getString("processInstanceId");
        if (obj.containsKey("result") && obj.getString("result").equals("agree")) {
            MaterialOddInf materialOddInf = new MaterialOddInf();
            //数据库中该条数据审核状态变为审核通过
            materialOddInf.setState("同意审核--原料销售订单");
            materialOddInf.setProcessInstanceId(processInstanceId);
            int count = this.updateStatusMaterialOddInf(materialOddInf);
            if (count > 0) {
                return true;
            } else {
                return false;
            }
        } else if (obj.containsKey("result") && obj.getString("result").equals("refuse")) {
            MaterialOddInf materialOddInf = new MaterialOddInf();
            materialOddInf.setState("拒绝审核--原料销售订单");
            materialOddInf.setProcessInstanceId(processInstanceId);
            int count = this.updateStatusMaterialOddInf(materialOddInf);
            if (count > 0) {
                return true;
            } else {
                return false;
            }
        }
        return false;
    }
}
