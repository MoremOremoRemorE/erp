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
        textForm1.setName("单据编号");
        textForm1.setValue(roughOddVaryInf.getDh());

        ProcessInstanceInputVO.TextForm textForm2 = new ProcessInstanceInputVO.TextForm();
        textForm2.setName("制单日期");
        textForm2.setValue(roughOddVaryInf.getRq());

        ProcessInstanceInputVO.TextForm textForm3 = new ProcessInstanceInputVO.TextForm();
        textForm3.setName("供应商名称");
        textForm3.setValue(roughOddVaryInf.getCltName());

        ProcessInstanceInputVO.TextForm textForm4 = new ProcessInstanceInputVO.TextForm();
        textForm4.setName("经办人");
        textForm4.setValue(roughOddVaryInf.getEmplName());

        ProcessInstanceInputVO.TextForm textForm5 = new ProcessInstanceInputVO.TextForm();
        textForm5.setName("制单人");
        textForm5.setValue(roughOddVaryInf.getCrtorName());

        ProcessInstanceInputVO.TextForm textForm6 = new ProcessInstanceInputVO.TextForm();
        textForm6.setName("制单时间");
        textForm6.setValue(roughOddVaryInf.getCrtorDT());

        ProcessInstanceInputVO.TextForm textForm7 = new ProcessInstanceInputVO.TextForm();
        textForm7.setName("修改人");
        textForm7.setValue(roughOddVaryInf.getMdferName());

        ProcessInstanceInputVO.TextForm textForm8 = new ProcessInstanceInputVO.TextForm();
        textForm8.setName("修改时间");
        textForm8.setValue(roughOddVaryInf.getMdfDT());

        ProcessInstanceInputVO.TextForm textForm9 = new ProcessInstanceInputVO.TextForm();
        textForm9.setName("单据状态");
        textForm9.setValue(roughOddVaryInf.getState());

        ProcessInstanceInputVO.TextForm textForm10 = new ProcessInstanceInputVO.TextForm();
        textForm10.setName("备注");
        textForm10.setValue(roughOddVaryInf.getRemark());

        //明细部分
        ProcessInstanceInputVO.TextForm textForm11 = new ProcessInstanceInputVO.TextForm();
        textForm11.setName("成品编码");
        textForm11.setValue(roughOddVaryInf.getProductCode());

        ProcessInstanceInputVO.TextForm textForm12 = new ProcessInstanceInputVO.TextForm();
        textForm12.setName("成品名称");
        textForm12.setValue(roughOddVaryInf.getProductName());

        ProcessInstanceInputVO.TextForm textForm13 = new ProcessInstanceInputVO.TextForm();
        textForm13.setName("供应商品");
        textForm13.setValue(roughOddVaryInf.getSupplyName());

        ProcessInstanceInputVO.TextForm textForm14 = new ProcessInstanceInputVO.TextForm();
        textForm14.setName("批号");
        textForm14.setValue(roughOddVaryInf.getBatch());

        ProcessInstanceInputVO.TextForm textForm15 = new ProcessInstanceInputVO.TextForm();
        textForm15.setName("规格");
        textForm15.setValue(roughOddVaryInf.getSpec());

        ProcessInstanceInputVO.TextForm textForm16 = new ProcessInstanceInputVO.TextForm();
        textForm16.setName("等级");
        textForm16.setValue(roughOddVaryInf.getLeve());

        ProcessInstanceInputVO.TextForm textForm17 = new ProcessInstanceInputVO.TextForm();
        textForm17.setName("计价单位");
        textForm17.setValue(roughOddVaryInf.getJjUnitName());

        ProcessInstanceInputVO.TextForm textForm18 = new ProcessInstanceInputVO.TextForm();
        textForm18.setName("计价数量");
        textForm18.setValue(roughOddVaryInf.getJjQty().toString());

        ProcessInstanceInputVO.TextForm textForm19 = new ProcessInstanceInputVO.TextForm();
        textForm19.setName("单位");
        textForm19.setValue(roughOddVaryInf.getUnitName());

        ProcessInstanceInputVO.TextForm textForm20 = new ProcessInstanceInputVO.TextForm();
        textForm20.setName("数量");
        textForm20.setValue(roughOddVaryInf.getQty().toString());

        ProcessInstanceInputVO.TextForm textForm21 = new ProcessInstanceInputVO.TextForm();
        textForm21.setName("交货日期");
        textForm21.setValue(roughOddVaryInf.getDeliveryDT());

        ProcessInstanceInputVO.TextForm textForm22 = new ProcessInstanceInputVO.TextForm();
        textForm22.setName("备注");
        textForm22.setValue(roughOddVaryInf.getRemarkC());

        ProcessInstanceInputVO.TextForm textForm23 = new ProcessInstanceInputVO.TextForm();
        textForm23.setName("变更计价数量");
        textForm23.setValue(roughOddVaryInf.getJjQtyV().toString());

        ProcessInstanceInputVO.TextForm textForm24 = new ProcessInstanceInputVO.TextForm();
        textForm24.setName("变更数量");
        textForm24.setValue(roughOddVaryInf.getQtyV().toString());

        ProcessInstanceInputVO.TextForm textForm25 = new ProcessInstanceInputVO.TextForm();
        textForm25.setName("变更件数");
        textForm25.setValue(roughOddVaryInf.getPQtyV().toString());

        ProcessInstanceInputVO.TextForm textForm26 = new ProcessInstanceInputVO.TextForm();
        textForm26.setName("变更时间");
        textForm26.setValue(roughOddVaryInf.getDeliveryDTV());

        ProcessInstanceInputVO.TextForm textForm27 = new ProcessInstanceInputVO.TextForm();
        textForm27.setName("变更原因");
        textForm27.setValue(roughOddVaryInf.getVaryReason());

        ProcessInstanceInputVO.TextForm textForm28 = new ProcessInstanceInputVO.TextForm();
        textForm28.setName("选择单号");
        textForm28.setValue(roughOddVaryInf.getBarDh());

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
