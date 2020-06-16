package com.erp.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.erp.mapper.RoughOrdInfMapper;
import com.erp.mapper.UserMapper;
import com.erp.model.RoughOrdInf;
import com.erp.model.User;
import com.erp.service.RoughOrdInfService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author jcq
 * 坯布销售订单服务层
 */
@Service
public class RoughOrdInfServiceImpl extends ServiceImpl<UserMapper, User>  implements RoughOrdInfService {

    @Autowired
    private RoughOrdInfMapper roughOrdInfMapper;
    @Override
    public int selectRoughOrdInfCount() {
        return roughOrdInfMapper.selectRoughOrdInfCount();
    }

    @Override
    public List<RoughOrdInf> selectApproveUser() {
        return roughOrdInfMapper.selectApproveUser();
    }

    @Override
    public int updateProcessInstanceIdRoughOrdInf(RoughOrdInf roughOrdInf) {
        return roughOrdInfMapper.updateProcessInstanceIdRoughOrdInf(roughOrdInf);
    }

    @Override
    public int updateStatusRoughOrdInf(RoughOrdInf roughOrdInf) {
        return roughOrdInfMapper.updateStatusRoughOrdInf(roughOrdInf);
    }

    @Override
    public Boolean returnResult(String plainText) {
        JSONObject obj = JSON.parseObject(plainText);
        String processInstanceId=obj.getString("processInstanceId");
        if (obj.containsKey("result") && obj.getString("result").equals("agree")) {
                RoughOrdInf roughOrdInf = new RoughOrdInf();
                //数据库中该条数据审核状态变为审核通过
                roughOrdInf.setState("同意审核--坯布销售订单");
                roughOrdInf.setProcessInstanceId(processInstanceId);
                int count = this.updateStatusRoughOrdInf(roughOrdInf);
                if (count > 0) {
                    return true;
                } else {
                    return false;
                }
            } else if (obj.containsKey("result") && obj.getString("result").equals("refuse")) {
                RoughOrdInf roughOrdInf = new RoughOrdInf();
                roughOrdInf.setState("拒绝审核--坯布销售订单");
                roughOrdInf.setProcessInstanceId(processInstanceId);
                int count = this.updateStatusRoughOrdInf(roughOrdInf);
                if (count > 0) {
                    return true;
                } else {
                   return false;
                }
            }
        return false;
    }
}
