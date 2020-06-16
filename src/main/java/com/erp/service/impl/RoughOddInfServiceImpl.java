package com.erp.service.impl;

import com.erp.mapper.RoughOddInfMapper;
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
}
