package com.erp.model.FormMsg;

import com.erp.model.ProcessInstanceInputVO;
import com.erp.model.RoughOddInf;

import java.util.ArrayList;
import java.util.List;

/**
 * 坯布采购订单模板
 */
public class RoughOddInfMsg {

    public static ProcessInstanceInputVO getProcessInstanceInputVORoughOddInf(RoughOddInf roughOddInf) {
        ProcessInstanceInputVO processInstance = new ProcessInstanceInputVO();

        List<ProcessInstanceInputVO.TextForm> textForms = new ArrayList<>();
        //审核人部门id
        processInstance.setDeptId(roughOddInf.getDeptId());
        //审核发起人userid
        processInstance.setOriginatorUserId(roughOddInf.getUserId());

        ProcessInstanceInputVO.TextForm textForm = new ProcessInstanceInputVO.TextForm();
        textForm.setName("订单号");
        textForm.setValue(roughOddInf.getCusDh());

        ProcessInstanceInputVO.TextForm textForm1 = new ProcessInstanceInputVO.TextForm();
        textForm.setName("版本号");
        textForm.setValue(roughOddInf.getVersion().toString());

        ProcessInstanceInputVO.TextForm textForm2 = new ProcessInstanceInputVO.TextForm();
        textForm.setName("单据编号");
        textForm.setValue(roughOddInf.getDh());

        ProcessInstanceInputVO.TextForm textForm3 = new ProcessInstanceInputVO.TextForm();
        textForm.setName("制单日期");
        textForm.setValue(roughOddInf.getRq());

        ProcessInstanceInputVO.TextForm textForm4 = new ProcessInstanceInputVO.TextForm();
        textForm.setName("供应商名称");
        textForm.setValue(roughOddInf.getCltName());

        ProcessInstanceInputVO.TextForm textForm5 = new ProcessInstanceInputVO.TextForm();
        textForm.setName("售价类型");
        textForm.setValue(roughOddInf.getSellSrtName());

        ProcessInstanceInputVO.TextForm textForm6 = new ProcessInstanceInputVO.TextForm();
        textForm.setName("币别信息");
        textForm.setValue(roughOddInf.getCurrName());

        ProcessInstanceInputVO.TextForm textForm7 = new ProcessInstanceInputVO.TextForm();
        textForm.setName("汇率");
        textForm.setValue(roughOddInf.getExcRate().toString());

        ProcessInstanceInputVO.TextForm textForm8 = new ProcessInstanceInputVO.TextForm();
        textForm.setName("业务员");
        textForm.setValue(roughOddInf.getEmplName());

        ProcessInstanceInputVO.TextForm textForm9 = new ProcessInstanceInputVO.TextForm();
        textForm.setName("交货地址");
        textForm.setValue(roughOddInf.getDeliveryAdd());

        ProcessInstanceInputVO.TextForm textForm10 = new ProcessInstanceInputVO.TextForm();
        textForm.setName("制单人");
        textForm.setValue(roughOddInf.getCrtoName());

        ProcessInstanceInputVO.TextForm textForm11 = new ProcessInstanceInputVO.TextForm();
        textForm.setName("制单时间");
        textForm.setValue(roughOddInf.getCrtorDT());

        ProcessInstanceInputVO.TextForm textForm12 = new ProcessInstanceInputVO.TextForm();
        textForm.setName("修改人");
        textForm.setValue(roughOddInf.getMdferName());

        ProcessInstanceInputVO.TextForm textForm13 = new ProcessInstanceInputVO.TextForm();
        textForm.setName("修改时间");
        textForm.setValue(roughOddInf.getMdfDT());

        ProcessInstanceInputVO.TextForm textForm14 = new ProcessInstanceInputVO.TextForm();
        textForm.setName("单据状态");
        textForm.setValue(roughOddInf.getState());

        ProcessInstanceInputVO.TextForm textForm15 = new ProcessInstanceInputVO.TextForm();
        textForm.setName("备注");
        textForm.setValue(roughOddInf.getRemark());

        //明细部分
        ProcessInstanceInputVO.TextForm textForm16 = new ProcessInstanceInputVO.TextForm();
        textForm.setName("成品编码");
        textForm.setValue(roughOddInf.getProductCode());

        ProcessInstanceInputVO.TextForm textForm17 = new ProcessInstanceInputVO.TextForm();
        textForm.setName("成品名称");
        textForm.setValue(roughOddInf.getProductName());

        ProcessInstanceInputVO.TextForm textForm18 = new ProcessInstanceInputVO.TextForm();
        textForm.setName("供应商品");
        textForm.setValue(roughOddInf.getSupplyName());

        ProcessInstanceInputVO.TextForm textForm19 = new ProcessInstanceInputVO.TextForm();
        textForm.setName("批号");
        textForm.setValue(roughOddInf.getBatch());

        ProcessInstanceInputVO.TextForm textForm20 = new ProcessInstanceInputVO.TextForm();
        textForm.setName("规格");
        textForm.setValue(roughOddInf.getSpec());

        ProcessInstanceInputVO.TextForm textForm21 = new ProcessInstanceInputVO.TextForm();
        textForm.setName("等级");
        textForm.setValue(roughOddInf.getLeve());

        ProcessInstanceInputVO.TextForm textForm22 = new ProcessInstanceInputVO.TextForm();
        textForm.setName("计价单位");
        textForm.setValue(roughOddInf.getJjUnitName());

        ProcessInstanceInputVO.TextForm textForm23 = new ProcessInstanceInputVO.TextForm();
        textForm.setName("计价数量");
        textForm.setValue(roughOddInf.getJjQty().toString());

        ProcessInstanceInputVO.TextForm textForm24 = new ProcessInstanceInputVO.TextForm();
        textForm.setName("单价");
        textForm.setValue(roughOddInf.getPrice().toString());

        ProcessInstanceInputVO.TextForm textForm25 = new ProcessInstanceInputVO.TextForm();
        textForm.setName("税率");
        textForm.setValue(roughOddInf.getTaxRate().toString());

        ProcessInstanceInputVO.TextForm textForm26 = new ProcessInstanceInputVO.TextForm();
        textForm.setName("金额");
        textForm.setValue(roughOddInf.getMoney().toString());

        ProcessInstanceInputVO.TextForm textForm27 = new ProcessInstanceInputVO.TextForm();
        textForm.setName("数量");
        textForm.setValue(roughOddInf.getQty().toString());

        ProcessInstanceInputVO.TextForm textForm28 = new ProcessInstanceInputVO.TextForm();
        textForm.setName("不含税单价");
        textForm.setValue(roughOddInf.getTaxPrice().toString());

        ProcessInstanceInputVO.TextForm textForm29 = new ProcessInstanceInputVO.TextForm();
        textForm.setName("税额");
        textForm.setValue(roughOddInf.getTaxMoney().toString());

        ProcessInstanceInputVO.TextForm textForm30 = new ProcessInstanceInputVO.TextForm();
        textForm.setName("不含税金额");
        textForm.setValue(roughOddInf.getSumMoney().toString());

        ProcessInstanceInputVO.TextForm textForm31 = new ProcessInstanceInputVO.TextForm();
        textForm.setName("短交");
        textForm.setValue(roughOddInf.getShortRate().toString());

        ProcessInstanceInputVO.TextForm textForm32 = new ProcessInstanceInputVO.TextForm();
        textForm.setName("超交");
        textForm.setValue(roughOddInf.getBeyondRate().toString());

        ProcessInstanceInputVO.TextForm textForm33 = new ProcessInstanceInputVO.TextForm();
        textForm.setName("交货日期");
        textForm.setValue(roughOddInf.getDeliveryDT());

        ProcessInstanceInputVO.TextForm textForm34 = new ProcessInstanceInputVO.TextForm();
        textForm.setName("备注");
        textForm.setValue(roughOddInf.getRemarkC());

		/*textForm.setName("[\\\"开始时间\\\",\\\"结束时间\\\"]");
		//处理时间控件的问题
		String time = test.getTime();
		String[] time1 = time.split(",");
		String time2 = "";
		time2 = "[\\\"" + time1[0] + "," + "\\\"" + time1[1] + "\\\"]";
		textForm.setValue(time2);*/

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

        processInstance.setTextForms(textForms);
        return processInstance;
    }

}
