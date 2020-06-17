package com.erp.model.FormMsg;

import com.erp.model.MaterialOrdInf;
import com.erp.model.ProcessInstanceInputVO;
import com.erp.util.DateUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * 原料销售订单模板
 */
public class MaterialOrdInfMsg  {

    public static ProcessInstanceInputVO getProcessInstanceInputVOMaterialOrdInf(MaterialOrdInf materialOrdInf) {
        ProcessInstanceInputVO processInstance = new ProcessInstanceInputVO();

        List<ProcessInstanceInputVO.TextForm> textForms = new ArrayList<>();
        //审核人部门id
        processInstance.setDeptId(materialOrdInf.getDeptId());
        //审核发起人userid
        processInstance.setOriginatorUserId(materialOrdInf.getUserId());

        ProcessInstanceInputVO.TextForm textForm = new ProcessInstanceInputVO.TextForm();
        textForm.setName("订单号");
        textForm.setValue(materialOrdInf.getCusDh());

        ProcessInstanceInputVO.TextForm textForm1 = new ProcessInstanceInputVO.TextForm();
        textForm1.setName("版本号");
        textForm1.setValue(materialOrdInf.getVersion().toString());

        ProcessInstanceInputVO.TextForm textForm2 = new ProcessInstanceInputVO.TextForm();
        textForm2.setName("单据编号");
        textForm2.setValue(materialOrdInf.getDh());

        ProcessInstanceInputVO.TextForm textForm3 = new ProcessInstanceInputVO.TextForm();
        textForm3.setName("制单日期");
        textForm3.setValue(materialOrdInf.getRq());

        ProcessInstanceInputVO.TextForm textForm4 = new ProcessInstanceInputVO.TextForm();
        textForm4.setName("客户名称");
        textForm4.setValue(materialOrdInf.getCltName());

        ProcessInstanceInputVO.TextForm textForm5 = new ProcessInstanceInputVO.TextForm();
        textForm5.setName("售价类型");
        textForm5.setValue(materialOrdInf.getSellSrtName());

        ProcessInstanceInputVO.TextForm textForm6 = new ProcessInstanceInputVO.TextForm();
        textForm6.setName("币种信息");
        textForm6.setValue(materialOrdInf.getCurrName());

        ProcessInstanceInputVO.TextForm textForm7 = new ProcessInstanceInputVO.TextForm();
        textForm7.setName("汇率");
        textForm7.setValue(materialOrdInf.getExcRate().toString());

        ProcessInstanceInputVO.TextForm textForm8 = new ProcessInstanceInputVO.TextForm();
        textForm8.setName("业务员");
        textForm8.setValue(materialOrdInf.getEmplName());

        ProcessInstanceInputVO.TextForm textForm9 = new ProcessInstanceInputVO.TextForm();
        textForm9.setName("交货地址");
        textForm9.setValue(materialOrdInf.getDeliveryAdd());

        ProcessInstanceInputVO.TextForm textForm10 = new ProcessInstanceInputVO.TextForm();
        textForm10.setName("包装方式");
        textForm10.setValue(materialOrdInf.getPackModName());

        ProcessInstanceInputVO.TextForm textForm11 = new ProcessInstanceInputVO.TextForm();
        textForm11.setName("运输方式");
        textForm11.setValue(materialOrdInf.getTrffcModName());

        ProcessInstanceInputVO.TextForm textForm12 = new ProcessInstanceInputVO.TextForm();
        textForm12.setName("制单人");
        textForm12.setValue(materialOrdInf.getCrtorName());

        ProcessInstanceInputVO.TextForm textForm13 = new ProcessInstanceInputVO.TextForm();
        textForm13.setName("制单时间");
        textForm13.setValue(materialOrdInf.getCrtorDT());

        ProcessInstanceInputVO.TextForm textForm14 = new ProcessInstanceInputVO.TextForm();
        textForm14.setName("修改人");
        textForm14.setValue(materialOrdInf.getMdferName());

        ProcessInstanceInputVO.TextForm textForm15 = new ProcessInstanceInputVO.TextForm();
        textForm15.setName("修改时间");
        textForm15.setValue(materialOrdInf.getMdfDT());

        ProcessInstanceInputVO.TextForm textForm16 = new ProcessInstanceInputVO.TextForm();
        textForm16.setName("单据状态");
        textForm16.setValue(materialOrdInf.getState());

        ProcessInstanceInputVO.TextForm textForm17 = new ProcessInstanceInputVO.TextForm();
        textForm17.setName("备注");
        textForm17.setValue(materialOrdInf.getRemark());


        /**
         * 明细部分
         */
        ProcessInstanceInputVO.TextForm textForm18 = new ProcessInstanceInputVO.TextForm();
        textForm18.setName("原料编码");
        textForm18.setValue(materialOrdInf.getProductCode());

        ProcessInstanceInputVO.TextForm textForm19 = new ProcessInstanceInputVO.TextForm();
        textForm19.setName("原料名称");
        textForm19.setValue(materialOrdInf.getProductName());

        ProcessInstanceInputVO.TextForm textForm20 = new ProcessInstanceInputVO.TextForm();
        textForm20.setName("批号");
        textForm20.setValue(materialOrdInf.getBatch());

        ProcessInstanceInputVO.TextForm textForm21 = new ProcessInstanceInputVO.TextForm();
        textForm21.setName("规格");
        textForm21.setValue(materialOrdInf.getSpec());

        ProcessInstanceInputVO.TextForm textForm22 = new ProcessInstanceInputVO.TextForm();
        textForm22.setName("等级");
        textForm22.setValue(materialOrdInf.getLeve());

        ProcessInstanceInputVO.TextForm textForm23 = new ProcessInstanceInputVO.TextForm();
        textForm23.setName("单位");
        textForm23.setValue(materialOrdInf.getUnitName());

        ProcessInstanceInputVO.TextForm textForm24 = new ProcessInstanceInputVO.TextForm();
        textForm24.setName("数量");
        textForm24.setValue(materialOrdInf.getQty().toString());

        ProcessInstanceInputVO.TextForm textForm25 = new ProcessInstanceInputVO.TextForm();
        textForm25.setName("件数");
        textForm25.setValue(materialOrdInf.getPQty().toString());

        ProcessInstanceInputVO.TextForm textForm26 = new ProcessInstanceInputVO.TextForm();
        textForm26.setName("单价");
        textForm26.setValue(materialOrdInf.getPrice().toString());

        ProcessInstanceInputVO.TextForm textForm27 = new ProcessInstanceInputVO.TextForm();
        textForm27.setName("税率");
        textForm27.setValue(materialOrdInf.getTaxRate().toString());

        ProcessInstanceInputVO.TextForm textForm28 = new ProcessInstanceInputVO.TextForm();
        textForm28.setName("不含税单价");
        textForm28.setValue(materialOrdInf.getTaxPrice().toString());

        ProcessInstanceInputVO.TextForm textForm29 = new ProcessInstanceInputVO.TextForm();
        textForm29.setName("金额");
        textForm29.setValue(materialOrdInf.getMoney().toString());

        ProcessInstanceInputVO.TextForm textForm30 = new ProcessInstanceInputVO.TextForm();
        textForm30.setName("税额");
        textForm30.setValue(materialOrdInf.getTaxMoney().toString());

        ProcessInstanceInputVO.TextForm textForm31 = new ProcessInstanceInputVO.TextForm();
        textForm31.setName("不含税金额");
        textForm31.setValue(materialOrdInf.getSumMoney().toString());

        ProcessInstanceInputVO.TextForm textForm32 = new ProcessInstanceInputVO.TextForm();
        textForm32.setName("短交");
        textForm32.setValue(materialOrdInf.getShortRate().toString());

        ProcessInstanceInputVO.TextForm textForm33 = new ProcessInstanceInputVO.TextForm();
        textForm33.setName("超交");
        textForm33.setValue(materialOrdInf.getBeyondRate().toString());

        ProcessInstanceInputVO.TextForm textForm34 = new ProcessInstanceInputVO.TextForm();
        textForm34.setName("交货日期");
        textForm34.setValue(materialOrdInf.getDeliveryDT());

        ProcessInstanceInputVO.TextForm textForm35 = new ProcessInstanceInputVO.TextForm();
        textForm35.setName("备注");
        textForm35.setValue(materialOrdInf.getRemarkC());


        textForms.add(textForm);
        textForms.add(textForm1);
        textForms.add(textForm2);
        textForms.add(textForm3);
        textForms.add(textForm4);
        textForms.add(textForm5);
        textForms.add(textForm6);
        textForms.add(textForm7);
        textForms.add(textForm8);
        textForms.add(textForm9);
        textForms.add(textForm10);
        textForms.add(textForm11);
        textForms.add(textForm12);
        textForms.add(textForm13);
        textForms.add(textForm14);
        textForms.add(textForm15);
        textForms.add(textForm16);
        textForms.add(textForm17);
        textForms.add(textForm18);
        textForms.add(textForm19);
        textForms.add(textForm20);
        textForms.add(textForm21);
        textForms.add(textForm22);
        textForms.add(textForm23);
        textForms.add(textForm24);
        textForms.add(textForm25);
        textForms.add(textForm26);
        textForms.add(textForm27);
        textForms.add(textForm28);
        textForms.add(textForm29);
        textForms.add(textForm30);
        textForms.add(textForm31);
        textForms.add(textForm32);
        textForms.add(textForm33);
        textForms.add(textForm34);
        textForms.add(textForm35);

        processInstance.setTextForms(textForms);
        return processInstance;
    }

}
