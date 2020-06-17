package com.erp.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.erp.mapper.MaterialOrdInfMapper;
import com.erp.model.MaterialOrdInf;
import com.erp.model.PaymentInf;
import com.erp.service.MaterialOrdInfService;
import com.erp.service.PaymentInfService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class MaterialOrdInfServiceImpl implements MaterialOrdInfService {
    @Autowired
    private MaterialOrdInfMapper materialOrdInfMapper;


    @Override
    public int selectMaterialOrdInfCount() {
        return materialOrdInfMapper.selectMaterialOrdInfCount();
    }

    @Override
    public List<MaterialOrdInf> selectApproveUser() {
        return materialOrdInfMapper.selectApproveUser();
    }

    @Override
    public int updateProcessInstanceIdMaterialOrdInf(MaterialOrdInf materialOrdInf) {
        return materialOrdInfMapper.updateProcessInstanceIdMaterialOrdInf(materialOrdInf);
    }

    @Override
    public int updateStatusMaterialOrdInf(MaterialOrdInf materialOrdInf) {
        return materialOrdInfMapper.updateStatusMaterialOrdInf(materialOrdInf);
    }

    @Override
    public Boolean returnResult(String plainText) {
        JSONObject obj = JSON.parseObject(plainText);
        String processInstanceId=obj.getString("processInstanceId");
        if (obj.containsKey("result") && obj.getString("result").equals("agree")) {
            MaterialOrdInf materialOrdInf = new MaterialOrdInf();
            //数据库中该条数据审核状态变为审核通过
            materialOrdInf.setState("同意审核--原料销售订单");
            materialOrdInf.setProcessInstanceId(processInstanceId);
            int count = this.updateStatusMaterialOrdInf(materialOrdInf);
            if (count > 0) {
                return true;
            } else {
                return false;
            }
        } else if (obj.containsKey("result") && obj.getString("result").equals("refuse")) {
            MaterialOrdInf materialOrdInf = new MaterialOrdInf();
            materialOrdInf.setState("拒绝审核--原料销售订单");
            materialOrdInf.setProcessInstanceId(processInstanceId);
            int count = this.updateStatusMaterialOrdInf(materialOrdInf);
            if (count > 0) {
                return true;
            } else {
                return false;
            }
        }
        return false;
    }


}
