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
        textForm1.setName("版本号");
        textForm1.setValue(roughOddInf.getVersion().toString());

        ProcessInstanceInputVO.TextForm textForm2 = new ProcessInstanceInputVO.TextForm();
        textForm2.setName("单据编号");
        textForm2.setValue(roughOddInf.getDh());

        ProcessInstanceInputVO.TextForm textForm3 = new ProcessInstanceInputVO.TextForm();
        textForm3.setName("制单日期");
        textForm3.setValue(roughOddInf.getRq());

        ProcessInstanceInputVO.TextForm textForm4 = new ProcessInstanceInputVO.TextForm();
        textForm4.setName("供应商名称");
        textForm4.setValue(roughOddInf.getCltName());

        ProcessInstanceInputVO.TextForm textForm5 = new ProcessInstanceInputVO.TextForm();
        textForm5.setName("售价类型");
        textForm5.setValue(roughOddInf.getSellSrtName());

        ProcessInstanceInputVO.TextForm textForm6 = new ProcessInstanceInputVO.TextForm();
        textForm6.setName("币别信息");
        textForm6.setValue(roughOddInf.getCurrName());

        ProcessInstanceInputVO.TextForm textForm7 = new ProcessInstanceInputVO.TextForm();
        textForm7.setName("汇率");
        textForm7.setValue(roughOddInf.getExcRate().toString());

        ProcessInstanceInputVO.TextForm textForm8 = new ProcessInstanceInputVO.TextForm();
        textForm8.setName("业务员");
        textForm8.setValue(roughOddInf.getEmplName());

        ProcessInstanceInputVO.TextForm textForm9 = new ProcessInstanceInputVO.TextForm();
        textForm9.setName("交货地址");
        textForm9.setValue(roughOddInf.getDeliveryAdd());

        ProcessInstanceInputVO.TextForm textForm10 = new ProcessInstanceInputVO.TextForm();
        textForm10.setName("制单人");
        textForm10.setValue(roughOddInf.getCrtoName());

        ProcessInstanceInputVO.TextForm textForm11 = new ProcessInstanceInputVO.TextForm();
        textForm11.setName("制单时间");
        textForm11.setValue(roughOddInf.getCrtorDT());

        ProcessInstanceInputVO.TextForm textForm12 = new ProcessInstanceInputVO.TextForm();
        textForm12.setName("修改人");
        textForm12.setValue(roughOddInf.getMdferName());

        ProcessInstanceInputVO.TextForm textForm13 = new ProcessInstanceInputVO.TextForm();
        textForm13.setName("修改时间");
        textForm13.setValue(roughOddInf.getMdfDT());

        ProcessInstanceInputVO.TextForm textForm14 = new ProcessInstanceInputVO.TextForm();
        textForm14.setName("单据状态");
        textForm14.setValue(roughOddInf.getState());

        ProcessInstanceInputVO.TextForm textForm15 = new ProcessInstanceInputVO.TextForm();
        textForm15.setName("备注");
        textForm15.setValue(roughOddInf.getRemark());

        //明细部分
        ProcessInstanceInputVO.TextForm textForm16 = new ProcessInstanceInputVO.TextForm();
        textForm16.setName("成品编码");
        textForm16.setValue(roughOddInf.getProductCode());

        ProcessInstanceInputVO.TextForm textForm17 = new ProcessInstanceInputVO.TextForm();
        textForm17.setName("成品名称");
        textForm17.setValue(roughOddInf.getProductName());

        ProcessInstanceInputVO.TextForm textForm18 = new ProcessInstanceInputVO.TextForm();
        textForm18.setName("供应商品");
        textForm18.setValue(roughOddInf.getSupplyName());

        ProcessInstanceInputVO.TextForm textForm19 = new ProcessInstanceInputVO.TextForm();
        textForm19.setName("批号");
        textForm19.setValue(roughOddInf.getBatch());

        ProcessInstanceInputVO.TextForm textForm20 = new ProcessInstanceInputVO.TextForm();
        textForm20.setName("规格");
        textForm20.setValue(roughOddInf.getSpec());

        ProcessInstanceInputVO.TextForm textForm21 = new ProcessInstanceInputVO.TextForm();
        textForm21.setName("等级");
        textForm21.setValue(roughOddInf.getLeve());

        ProcessInstanceInputVO.TextForm textForm22 = new ProcessInstanceInputVO.TextForm();
        textForm22.setName("计价单位");
        textForm22.setValue(roughOddInf.getJjUnitName());

        ProcessInstanceInputVO.TextForm textForm23 = new ProcessInstanceInputVO.TextForm();
        textForm23.setName("计价数量");
        textForm23.setValue(roughOddInf.getJjQty().toString());

        ProcessInstanceInputVO.TextForm textForm24 = new ProcessInstanceInputVO.TextForm();
        textForm24.setName("单价");
        textForm24.setValue(roughOddInf.getPrice().toString());

        ProcessInstanceInputVO.TextForm textForm25 = new ProcessInstanceInputVO.TextForm();
        textForm25.setName("税率");
        textForm25.setValue(roughOddInf.getTaxRate().toString());

        ProcessInstanceInputVO.TextForm textForm26 = new ProcessInstanceInputVO.TextForm();
        textForm26.setName("金额");
        textForm26.setValue(roughOddInf.getMoney().toString());

        ProcessInstanceInputVO.TextForm textForm27 = new ProcessInstanceInputVO.TextForm();
        textForm27.setName("数量");
        textForm27.setValue(roughOddInf.getQty().toString());

        ProcessInstanceInputVO.TextForm textForm28 = new ProcessInstanceInputVO.TextForm();
        textForm28.setName("不含税单价");
        textForm28.setValue(roughOddInf.getTaxPrice().toString());

        ProcessInstanceInputVO.TextForm textForm29 = new ProcessInstanceInputVO.TextForm();
        textForm29.setName("税额");
        textForm29.setValue(roughOddInf.getTaxMoney().toString());

        ProcessInstanceInputVO.TextForm textForm30 = new ProcessInstanceInputVO.TextForm();
        textForm30.setName("不含税金额");
        textForm30.setValue(roughOddInf.getSumMoney().toString());

        ProcessInstanceInputVO.TextForm textForm31 = new ProcessInstanceInputVO.TextForm();
        textForm31.setName("短交");
        textForm31.setValue(roughOddInf.getShortRate().toString());

        ProcessInstanceInputVO.TextForm textForm32 = new ProcessInstanceInputVO.TextForm();
        textForm32.setName("超交");
        textForm32.setValue(roughOddInf.getBeyondRate().toString());

        ProcessInstanceInputVO.TextForm textForm33 = new ProcessInstanceInputVO.TextForm();
        textForm33.setName("交货日期");
        textForm33.setValue(roughOddInf.getDeliveryDT());

        ProcessInstanceInputVO.TextForm textForm34 = new ProcessInstanceInputVO.TextForm();
        textForm34.setName("备注");
        textForm34.setValue(roughOddInf.getRemarkC());

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
