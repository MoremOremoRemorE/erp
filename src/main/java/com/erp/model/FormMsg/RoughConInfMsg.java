package com.erp.model.FormMsg;

import com.erp.model.ProcessInstanceInputVO;
import com.erp.model.RoughConInf;

import java.util.ArrayList;
import java.util.List;

/**
 * 坯布采购订单模板
 */
public class RoughConInfMsg {

    public static ProcessInstanceInputVO getProcessInstanceInputVORoughConInf(RoughConInf roughConInf) {
        ProcessInstanceInputVO processInstance = new ProcessInstanceInputVO();

        List<ProcessInstanceInputVO.TextForm> textForms = new ArrayList<>();
        //审核人部门id
        processInstance.setDeptId(roughConInf.getDeptId());
        //审核发起人userid
        processInstance.setOriginatorUserId(roughConInf.getUserId());

        ProcessInstanceInputVO.TextForm textForm = new ProcessInstanceInputVO.TextForm();
        textForm.setName("版本号");
        textForm.setValue(roughConInf.getVersion().toString());

        ProcessInstanceInputVO.TextForm textForm1 = new ProcessInstanceInputVO.TextForm();
        textForm.setName("单据编号");
        textForm.setValue(roughConInf.getDh());

        ProcessInstanceInputVO.TextForm textForm2 = new ProcessInstanceInputVO.TextForm();
        textForm.setName("制单日期");
        textForm.setValue(roughConInf.getRq());

        ProcessInstanceInputVO.TextForm textForm3 = new ProcessInstanceInputVO.TextForm();
        textForm.setName("客户名称");
        textForm.setValue(roughConInf.getCltName());

        ProcessInstanceInputVO.TextForm textForm4 = new ProcessInstanceInputVO.TextForm();
        textForm.setName("业务员");
        textForm.setValue(roughConInf.getEmplName());

        ProcessInstanceInputVO.TextForm textForm5 = new ProcessInstanceInputVO.TextForm();
        textForm.setName("制单人");
        textForm.setValue(roughConInf.getCrtorName());

        ProcessInstanceInputVO.TextForm textForm6 = new ProcessInstanceInputVO.TextForm();
        textForm.setName("制单时间");
        textForm.setValue(roughConInf.getCrtorDT());

        ProcessInstanceInputVO.TextForm textForm7 = new ProcessInstanceInputVO.TextForm();
        textForm.setName("修改人");
        textForm.setValue(roughConInf.getMdferName());

        ProcessInstanceInputVO.TextForm textForm8 = new ProcessInstanceInputVO.TextForm();
        textForm.setName("修改时间");
        textForm.setValue(roughConInf.getMdfDT());

        ProcessInstanceInputVO.TextForm textForm9 = new ProcessInstanceInputVO.TextForm();
        textForm.setName("单据状态");
        textForm.setValue(roughConInf.getState());

        ProcessInstanceInputVO.TextForm textForm10 = new ProcessInstanceInputVO.TextForm();
        textForm.setName("备注");
        textForm.setValue(roughConInf.getRemark());

        //明细部分
        ProcessInstanceInputVO.TextForm textForm11 = new ProcessInstanceInputVO.TextForm();
        textForm.setName("成品编码");
        textForm.setValue(roughConInf.getProductCode());

        ProcessInstanceInputVO.TextForm textForm12 = new ProcessInstanceInputVO.TextForm();
        textForm.setName("成品名称");
        textForm.setValue(roughConInf.getProductName());

        ProcessInstanceInputVO.TextForm textForm13 = new ProcessInstanceInputVO.TextForm();
        textForm.setName("客户品名");
        textForm.setValue(roughConInf.getProName());

        ProcessInstanceInputVO.TextForm textForm14 = new ProcessInstanceInputVO.TextForm();
        textForm.setName("批号");
        textForm.setValue(roughConInf.getBatch());

        ProcessInstanceInputVO.TextForm textForm15 = new ProcessInstanceInputVO.TextForm();
        textForm.setName("规格");
        textForm.setValue(roughConInf.getSpec());

        ProcessInstanceInputVO.TextForm textForm16 = new ProcessInstanceInputVO.TextForm();
        textForm.setName("等级");
        textForm.setValue(roughConInf.getLeve());

        ProcessInstanceInputVO.TextForm textForm17 = new ProcessInstanceInputVO.TextForm();
        textForm.setName("克重");
        textForm.setValue(roughConInf.getFaw());

        ProcessInstanceInputVO.TextForm textForm18 = new ProcessInstanceInputVO.TextForm();
        textForm.setName("板号");
        textForm.setValue(roughConInf.getRoPrmtr4());

        ProcessInstanceInputVO.TextForm textForm19 = new ProcessInstanceInputVO.TextForm();
        textForm.setName("幅宽");
        textForm.setValue(roughConInf.getRoPrmtr2());

        ProcessInstanceInputVO.TextForm textForm20 = new ProcessInstanceInputVO.TextForm();
        textForm.setName("轴号");
        textForm.setValue(roughConInf.getRoPrmtr3());

        ProcessInstanceInputVO.TextForm textForm21 = new ProcessInstanceInputVO.TextForm();
        textForm.setName("计价单位");
        textForm.setValue(roughConInf.getJjUnitName());

        ProcessInstanceInputVO.TextForm textForm22 = new ProcessInstanceInputVO.TextForm();
        textForm.setName("计价数量");
        textForm.setValue(roughConInf.getJjQty().toString());

        ProcessInstanceInputVO.TextForm textForm23 = new ProcessInstanceInputVO.TextForm();
        textForm.setName("单位");
        textForm.setValue(roughConInf.getUnitName());

        ProcessInstanceInputVO.TextForm textForm24 = new ProcessInstanceInputVO.TextForm();
        textForm.setName("数量");
        textForm.setValue(roughConInf.getQty2().toString());

        ProcessInstanceInputVO.TextForm textForm25 = new ProcessInstanceInputVO.TextForm();
        textForm.setName("税率");
        textForm.setValue(roughConInf.getTaxRate().toString());

        ProcessInstanceInputVO.TextForm textForm26 = new ProcessInstanceInputVO.TextForm();
        textForm.setName("单价");
        textForm.setValue(roughConInf.getPrice().toString());

        ProcessInstanceInputVO.TextForm textForm27 = new ProcessInstanceInputVO.TextForm();
        textForm.setName("选择单号");
        textForm.setValue(roughConInf.getBarDh());

        ProcessInstanceInputVO.TextForm textForm28 = new ProcessInstanceInputVO.TextForm();
        textForm.setName("备注");
        textForm.setValue(roughConInf.getRemarkC());



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
