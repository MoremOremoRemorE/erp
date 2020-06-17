package com.erp.model.FormMsg;

import com.erp.model.ProcessInstanceInputVO;
import com.erp.model.ProjectOddInf;
import com.erp.model.RoughConInf;

import java.util.ArrayList;
import java.util.List;

/**
 * 工程合同
 */
public class ProjectOddInfMsg {

    public static ProcessInstanceInputVO getProcessInstanceInputVOProjectOddInf(ProjectOddInf projectOddInf) {
        ProcessInstanceInputVO processInstance = new ProcessInstanceInputVO();

        List<ProcessInstanceInputVO.TextForm> textForms = new ArrayList<>();
        //审核人部门id
        processInstance.setDeptId(projectOddInf.getDeptId());
        //审核发起人userid
        processInstance.setOriginatorUserId(projectOddInf.getUserId());

        ProcessInstanceInputVO.TextForm textForm = new ProcessInstanceInputVO.TextForm();
        textForm.setName("订单号");
        textForm.setValue(projectOddInf.getCusDh());

        ProcessInstanceInputVO.TextForm textForm1 = new ProcessInstanceInputVO.TextForm();
        textForm1.setName("版本号");
        textForm1.setValue(projectOddInf.getVersion().toString());

        ProcessInstanceInputVO.TextForm textForm2 = new ProcessInstanceInputVO.TextForm();
        textForm2.setName("单据编号");
        textForm2.setValue(projectOddInf.getDh());

        ProcessInstanceInputVO.TextForm textForm3 = new ProcessInstanceInputVO.TextForm();
        textForm3.setName("供应商名称");
        textForm3.setValue(projectOddInf.getCltName());

        ProcessInstanceInputVO.TextForm textForm4 = new ProcessInstanceInputVO.TextForm();
        textForm4.setName("制单日期");
        textForm4.setValue(projectOddInf.getRq());

        ProcessInstanceInputVO.TextForm textForm5 = new ProcessInstanceInputVO.TextForm();
        textForm5.setName("业务员名称");
        textForm5.setValue(projectOddInf.getEmplName());

        ProcessInstanceInputVO.TextForm textForm6 = new ProcessInstanceInputVO.TextForm();
        textForm6.setName("币别信息");
        textForm6.setValue(projectOddInf.getCurrName());

        ProcessInstanceInputVO.TextForm textForm7 = new ProcessInstanceInputVO.TextForm();
        textForm7.setName("汇率");
        textForm7.setValue(projectOddInf.getExcRate().toString());

        ProcessInstanceInputVO.TextForm textForm8 = new ProcessInstanceInputVO.TextForm();
        textForm8.setName("业务员");
        textForm8.setValue(projectOddInf.getEmplName1());

        ProcessInstanceInputVO.TextForm textForm9 = new ProcessInstanceInputVO.TextForm();
        textForm9.setName("交货地址");
        textForm9.setValue(projectOddInf.getDeliveryAdd());

        ProcessInstanceInputVO.TextForm textForm10 = new ProcessInstanceInputVO.TextForm();
        textForm10.setName("制单人");
        textForm10.setValue(projectOddInf.getCrtorName());

        ProcessInstanceInputVO.TextForm textForm11 = new ProcessInstanceInputVO.TextForm();
        textForm11.setName("制单时间");
        textForm11.setValue(projectOddInf.getCrtorName());

        ProcessInstanceInputVO.TextForm textForm12 = new ProcessInstanceInputVO.TextForm();
        textForm12.setName("修改人");
        textForm12.setValue(projectOddInf.getMdferName());

        ProcessInstanceInputVO.TextForm textForm13 = new ProcessInstanceInputVO.TextForm();
        textForm13.setName("修改时间");
        textForm13.setValue(projectOddInf.getMdfDT());

        ProcessInstanceInputVO.TextForm textForm14 = new ProcessInstanceInputVO.TextForm();
        textForm14.setName("单据状态");
        textForm14.setValue(projectOddInf.getState());

        ProcessInstanceInputVO.TextForm textForm15 = new ProcessInstanceInputVO.TextForm();
        textForm15.setName("备注");
        textForm15.setValue(projectOddInf.getRemark());

        //明细部分
        ProcessInstanceInputVO.TextForm textForm16 = new ProcessInstanceInputVO.TextForm();
        textForm16.setName("项目");
        textForm16.setValue(projectOddInf.getSpec());

        ProcessInstanceInputVO.TextForm textForm17 = new ProcessInstanceInputVO.TextForm();
        textForm17.setName("单位");
        textForm17.setValue(projectOddInf.getUnitName());

        ProcessInstanceInputVO.TextForm textForm18 = new ProcessInstanceInputVO.TextForm();
        textForm18.setName("数量");
        textForm18.setValue(projectOddInf.getQty().toString());

        ProcessInstanceInputVO.TextForm textForm19 = new ProcessInstanceInputVO.TextForm();
        textForm19.setName("税率");
        textForm19.setValue(projectOddInf.getTaxRate().toString());

        ProcessInstanceInputVO.TextForm textForm20 = new ProcessInstanceInputVO.TextForm();
        textForm20.setName("不含税单价");
        textForm20.setValue(projectOddInf.getTaxPrice().toString());

        ProcessInstanceInputVO.TextForm textForm21 = new ProcessInstanceInputVO.TextForm();
        textForm21.setName("金额");
        textForm21.setValue(projectOddInf.getMoney().toString());

        ProcessInstanceInputVO.TextForm textForm22 = new ProcessInstanceInputVO.TextForm();
        textForm22.setName("预付款比");
        textForm22.setValue(projectOddInf.getYfRate().toString());

        ProcessInstanceInputVO.TextForm textForm23 = new ProcessInstanceInputVO.TextForm();
        textForm23.setName("预付款");
        textForm23.setValue(projectOddInf.getYfMoney().toString());

        ProcessInstanceInputVO.TextForm textForm24 = new ProcessInstanceInputVO.TextForm();
        textForm24.setName("后付款金");
        textForm24.setValue(projectOddInf.getHfkMoney().toString());

        ProcessInstanceInputVO.TextForm textForm25 = new ProcessInstanceInputVO.TextForm();
        textForm25.setName("税额");
        textForm25.setValue(projectOddInf.getTaxMoney().toString());

        ProcessInstanceInputVO.TextForm textForm26 = new ProcessInstanceInputVO.TextForm();
        textForm26.setName("不含税金额");
        textForm26.setValue(projectOddInf.getSumMoney().toString());

        ProcessInstanceInputVO.TextForm textForm27 = new ProcessInstanceInputVO.TextForm();
        textForm27.setName("交货日期");
        textForm27.setValue(projectOddInf.getDeliveryDT());

        ProcessInstanceInputVO.TextForm textForm28 = new ProcessInstanceInputVO.TextForm();
        textForm28.setName("备注");
        textForm28.setValue(projectOddInf.getRemarkC());

        ProcessInstanceInputVO.TextForm textForm29 = new ProcessInstanceInputVO.TextForm();
        textForm29.setName("选择单号");
        textForm29.setValue(projectOddInf.getBarDh());

        ProcessInstanceInputVO.TextForm textForm30 = new ProcessInstanceInputVO.TextForm();
        textForm30.setName("业务状态");
        textForm30.setValue(projectOddInf.getUseStageC());


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

        processInstance.setTextForms(textForms);
        return processInstance;
    }

}
