package com.erp.service.impl;

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
}
