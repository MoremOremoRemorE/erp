package com.erp.model.FormMsg;

import com.erp.model.ProcessInstanceInputVO;
import com.erp.model.RoughOddVaryInf;

import java.util.ArrayList;
import java.util.List;

/**
 * 坯布采购变更单模板数据项
 */
public class RoughOddVaryInfMsg {
    /**
     * 坯布采购变更单模板
     * @param roughOddVaryInf
     * @return
     */
    public static ProcessInstanceInputVO getProcessInstanceInputVORoughOddVaryInf(RoughOddVaryInf roughOddVaryInf) {
        ProcessInstanceInputVO processInstance = new ProcessInstanceInputVO();

        List<ProcessInstanceInputVO.TextForm> textForms = new ArrayList<>();
        //审核人部门id
        processInstance.setDeptId(roughOddVaryInf.getDeptId());
        //审核发起人userid
        processInstance.setOriginatorUserId(roughOddVaryInf.getUserId());

        ProcessInstanceInputVO.TextForm textForm = new ProcessInstanceInputVO.TextForm();
        textForm.setName("版本号");
        textForm.setValue(roughOddVaryInf.getVersion().toString());

        ProcessInstanceInputVO.TextForm textForm1 = new ProcessInstanceInputVO.TextForm();
        textForm.setName("单据编号");
        textForm.setValue(roughOddVaryInf.getDh());

        ProcessInstanceInputVO.TextForm textForm2 = new ProcessInstanceInputVO.TextForm();
        textForm.setName("制单日期");
        textForm.setValue(roughOddVaryInf.getRq());

        ProcessInstanceInputVO.TextForm textForm3 = new ProcessInstanceInputVO.TextForm();
        textForm.setName("供应商名称");
        textForm.setValue(roughOddVaryInf.getCltName());

        ProcessInstanceInputVO.TextForm textForm4 = new ProcessInstanceInputVO.TextForm();
        textForm.setName("经办人");
        textForm.setValue(roughOddVaryInf.getEmplName());

        ProcessInstanceInputVO.TextForm textForm5 = new ProcessInstanceInputVO.TextForm();
        textForm.setName("制单人");
        textForm.setValue(roughOddVaryInf.getCrtorName());

        ProcessInstanceInputVO.TextForm textForm6 = new ProcessInstanceInputVO.TextForm();
        textForm.setName("制单时间");
        textForm.setValue(roughOddVaryInf.getCrtorDT());

        ProcessInstanceInputVO.TextForm textForm7 = new ProcessInstanceInputVO.TextForm();
        textForm.setName("修改人");
        textForm.setValue(roughOddVaryInf.getMdferName());

        ProcessInstanceInputVO.TextForm textForm8 = new ProcessInstanceInputVO.TextForm();
        textForm.setName("修改时间");
        textForm.setValue(roughOddVaryInf.getMdfDT());

        ProcessInstanceInputVO.TextForm textForm9 = new ProcessInstanceInputVO.TextForm();
        textForm.setName("单据状态");
        textForm.setValue(roughOddVaryInf.getState());

        ProcessInstanceInputVO.TextForm textForm10 = new ProcessInstanceInputVO.TextForm();
        textForm.setName("备注");
        textForm.setValue(roughOddVaryInf.getRemark());

        //明细部分
        ProcessInstanceInputVO.TextForm textForm11 = new ProcessInstanceInputVO.TextForm();
        textForm.setName("成品编码");
        textForm.setValue(roughOddVaryInf.getProductCode());

        ProcessInstanceInputVO.TextForm textForm12 = new ProcessInstanceInputVO.TextForm();
        textForm.setName("成品名称");
        textForm.setValue(roughOddVaryInf.getProductName());

        ProcessInstanceInputVO.TextForm textForm13 = new ProcessInstanceInputVO.TextForm();
        textForm.setName("供应商品");
        textForm.setValue(roughOddVaryInf.getSupplyName());

        ProcessInstanceInputVO.TextForm textForm14 = new ProcessInstanceInputVO.TextForm();
        textForm.setName("批号");
        textForm.setValue(roughOddVaryInf.getBatch());

        ProcessInstanceInputVO.TextForm textForm15 = new ProcessInstanceInputVO.TextForm();
        textForm.setName("规格");
        textForm.setValue(roughOddVaryInf.getSpec());

        ProcessInstanceInputVO.TextForm textForm16 = new ProcessInstanceInputVO.TextForm();
        textForm.setName("等级");
        textForm.setValue(roughOddVaryInf.getLeve());

        ProcessInstanceInputVO.TextForm textForm17 = new ProcessInstanceInputVO.TextForm();
        textForm.setName("计价单位");
        textForm.setValue(roughOddVaryInf.getJjUnitName());

        ProcessInstanceInputVO.TextForm textForm18 = new ProcessInstanceInputVO.TextForm();
        textForm.setName("计价数量");
        textForm.setValue(roughOddVaryInf.getJjQty().toString());

        ProcessInstanceInputVO.TextForm textForm19 = new ProcessInstanceInputVO.TextForm();
        textForm.setName("单位");
        textForm.setValue(roughOddVaryInf.getUnitName());

        ProcessInstanceInputVO.TextForm textForm20 = new ProcessInstanceInputVO.TextForm();
        textForm.setName("数量");
        textForm.setValue(roughOddVaryInf.getQty().toString());

        ProcessInstanceInputVO.TextForm textForm21 = new ProcessInstanceInputVO.TextForm();
        textForm.setName("交货日期");
        textForm.setValue(roughOddVaryInf.getDeliveryDT());

        ProcessInstanceInputVO.TextForm textForm22 = new ProcessInstanceInputVO.TextForm();
        textForm.setName("备注");
        textForm.setValue(roughOddVaryInf.getRemarkC());

        ProcessInstanceInputVO.TextForm textForm23 = new ProcessInstanceInputVO.TextForm();
        textForm.setName("变更计价数量");
        textForm.setValue(roughOddVaryInf.getJjQtyV().toString());

        ProcessInstanceInputVO.TextForm textForm24 = new ProcessInstanceInputVO.TextForm();
        textForm.setName("变更数量");
        textForm.setValue(roughOddVaryInf.getQtyV().toString());

        ProcessInstanceInputVO.TextForm textForm25 = new ProcessInstanceInputVO.TextForm();
        textForm.setName("变更件数");
        textForm.setValue(roughOddVaryInf.getPQtyV().toString());

        ProcessInstanceInputVO.TextForm textForm26 = new ProcessInstanceInputVO.TextForm();
        textForm.setName("变更时间");
        textForm.setValue(roughOddVaryInf.getDeliveryDTV());

        ProcessInstanceInputVO.TextForm textForm27 = new ProcessInstanceInputVO.TextForm();
        textForm.setName("变更原因");
        textForm.setValue(roughOddVaryInf.getVaryReason());

        ProcessInstanceInputVO.TextForm textForm28 = new ProcessInstanceInputVO.TextForm();
        textForm.setName("选择单号");
        textForm.setValue(roughOddVaryInf.getBarDh());

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

        processInstance.setTextForms(textForms);
        return processInstance;
    }
}
