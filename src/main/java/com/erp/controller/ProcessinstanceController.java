package com.erp.controller;

import com.erp.config.Constant;
import com.erp.config.URLConstant;
import com.dingtalk.api.DefaultDingTalkClient;
import com.dingtalk.api.DingTalkClient;
import com.dingtalk.api.request.OapiProcessinstanceCreateRequest;
import com.dingtalk.api.request.OapiProcessinstanceGetRequest;
import com.dingtalk.api.response.OapiProcessinstanceCreateResponse;
import com.dingtalk.api.response.OapiProcessinstanceGetResponse;
import com.erp.model.*;
import com.erp.service.RoughOrdInfService;
import com.erp.service.TestService;
import com.erp.service.UserService;
import com.erp.util.AccessTokenUtil;
import com.erp.util.LogFormatter;
import com.erp.util.LogFormatter.LogEvent;
import com.erp.util.ServiceResult;
import com.erp.util.ServiceResultCode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * 企业 E应用审批解决方案示例代码
 * 实现了审批的基础功能
 */
@RestController
public class ProcessinstanceController {

	@Autowired
	private  UserService userService;
	@Autowired
	private TestService testService;
	@Autowired
	private RoughOrdInfService roughOrdInfService;
	private static final Logger bizLogger = LoggerFactory.getLogger(com.erp.controller.ProcessinstanceController.class);

	/**
	 * 欢迎页面
	 */
	@RequestMapping(value = "/Processinstance/welcome", method = RequestMethod.GET)
	public String welcome() {
		return "welcome";
	}


	/**
	 * 发起审批,5s执行一次
	 */
	@Scheduled(cron = "5 * * * * ?")
	@RequestMapping(value = "/processinstance/start", method = RequestMethod.GET)
	@ResponseBody
	public ServiceResult<String> startProcessInstance() {

		//设置一个缓存线程池子，无限大
		ExecutorService cachedThreadPool = Executors.newCachedThreadPool();
		for (int i = 0; i < 10; i++) {
			final int index = i;
			try {
				Thread.sleep(index * 1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			cachedThreadPool.execute(new Runnable() {
				@Override
				public void run() {
					//查询的第一个测试数据
					startProcessInstance1();
				}
			});
		}

		ExecutorService cachedThreadPool1 = Executors.newCachedThreadPool();
		for (int i = 0; i < 10; i++) {
			final int index = i;
			try {
				Thread.sleep(index * 1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			cachedThreadPool1.execute(new Runnable() {
				@Override
				public void run() {
					//查询的第一个测试数据
					startProcessInstance2();
				}
			});
		}

		return ServiceResult.success("success");
	}

	/**
	 * 根据审批实例id获取审批详情
	 * @param instanceId
	 * @return
	 */
	@RequestMapping(value = "/pricessinstance/get", method = RequestMethod.POST)
	@ResponseBody
	public ServiceResult getProcessinstanceById(@RequestParam String instanceId) {
		try {
			DingTalkClient client = new DefaultDingTalkClient(URLConstant.URL_PROCESSINSTANCE_GET);
			OapiProcessinstanceGetRequest request = new OapiProcessinstanceGetRequest();
			request.setProcessInstanceId(instanceId);
			OapiProcessinstanceGetResponse response = client.execute(request, AccessTokenUtil.getToken());
			if (response.getErrcode().longValue() != 0) {
				return ServiceResult.failure(String.valueOf(response.getErrorCode()), response.getErrmsg());
			}
			return ServiceResult.success(response.getProcessInstance());
		} catch (Exception e) {
			String errLog = LogFormatter.getKVLogData(LogEvent.END,
				LogFormatter.KeyValue.getNew("instanceId", instanceId));
			bizLogger.info(errLog,e);
			return ServiceResult.failure(ServiceResultCode.SYS_ERROR.getErrCode(),ServiceResultCode.SYS_ERROR.getErrMsg());
		}
	}
	private OapiProcessinstanceCreateRequest.FormComponentValueVo generateFormWithTextForm(ProcessInstanceInputVO.TextForm textForm) {
		OapiProcessinstanceCreateRequest.FormComponentValueVo form = new OapiProcessinstanceCreateRequest.FormComponentValueVo();
		form.setName(textForm.getName());
		form.setValue(textForm.getValue());
		return form;
	}



	public  ProcessInstanceInputVO getProcessInstanceInputVOTest(Test test) {
		ProcessInstanceInputVO processInstance = new ProcessInstanceInputVO();

		List<ProcessInstanceInputVO.TextForm> textForms = new ArrayList<>();
		processInstance.setDeptId(test.getDeptId());
		processInstance.setOriginatorUserId(test.getUserId());
		ProcessInstanceInputVO.TextForm textForm = new ProcessInstanceInputVO.TextForm();
		textForm.setName("[\\\"开始时间\\\",\\\"结束时间\\\"]");
		//处理时间控件的问题
		String time = test.getTime();
		String[] time1 = time.split(",");
		String time2 = "";
		time2 = "[\\\"" + time1[0] + "," + "\\\"" + time1[1] + "\\\"]";
		textForm.setValue(time2);

		ProcessInstanceInputVO.TextForm textForm1 = new ProcessInstanceInputVO.TextForm();
		textForm1.setName("随便输");
		textForm1.setValue(test.getMessage());

		ProcessInstanceInputVO.TextForm textForm2 = new ProcessInstanceInputVO.TextForm();
		textForm2.setName("金额");
		textForm2.setValue(test.getMoney());

		textForms.add(textForm);
		textForms.add(textForm1);
		textForms.add(textForm2);

		processInstance.setTextForms(textForms);
		return processInstance;
	}

	/**
	 * 坯布销售订单模板
	 * @param roughOrdInf
	 * @return
	 */
	public  ProcessInstanceInputVO getProcessInstanceInputVORoughOrdInf(RoughOrdInf roughOrdInf) {
		ProcessInstanceInputVO processInstance = new ProcessInstanceInputVO();

		List<ProcessInstanceInputVO.TextForm> textForms = new ArrayList<>();
		//审核人部门id
		processInstance.setDeptId(roughOrdInf.getDeptId());
		//审核发起人userid
		processInstance.setOriginatorUserId(roughOrdInf.getUserId());

		ProcessInstanceInputVO.TextForm textForm = new ProcessInstanceInputVO.TextForm();
		textForm.setName("版本号");
		textForm.setValue(roughOrdInf.getVersion().toString());

		ProcessInstanceInputVO.TextForm textForm1 = new ProcessInstanceInputVO.TextForm();
		textForm.setName("单据编号");
		textForm.setValue(roughOrdInf.getDh());

		ProcessInstanceInputVO.TextForm textForm2 = new ProcessInstanceInputVO.TextForm();
		textForm.setName("制单日期");
		textForm.setValue(roughOrdInf.getRq());

		ProcessInstanceInputVO.TextForm textForm3 = new ProcessInstanceInputVO.TextForm();
		textForm.setName("客户名称");
		textForm.setValue(roughOrdInf.getCltName());

		ProcessInstanceInputVO.TextForm textForm4 = new ProcessInstanceInputVO.TextForm();
		textForm.setName("目标来源组织");
		textForm.setValue(roughOrdInf.getToOrgName());

		ProcessInstanceInputVO.TextForm textForm5 = new ProcessInstanceInputVO.TextForm();
		textForm.setName("售价类型");
		textForm.setValue(roughOrdInf.getSellSrtName());

		ProcessInstanceInputVO.TextForm textForm6 = new ProcessInstanceInputVO.TextForm();
		textForm.setName("币别信息");
		textForm.setValue(roughOrdInf.getCurrName());

		ProcessInstanceInputVO.TextForm textForm7 = new ProcessInstanceInputVO.TextForm();
		textForm.setName("汇率");
		textForm.setValue(roughOrdInf.getExcRate().toString());

		ProcessInstanceInputVO.TextForm textForm8 = new ProcessInstanceInputVO.TextForm();
		textForm.setName("业务员");
		textForm.setValue(roughOrdInf.getEmplName());

		ProcessInstanceInputVO.TextForm textForm9 = new ProcessInstanceInputVO.TextForm();
		textForm.setName("交货地址");
		textForm.setValue(roughOrdInf.getDeliveryAdd());

		ProcessInstanceInputVO.TextForm textForm10 = new ProcessInstanceInputVO.TextForm();
		textForm.setName("运输方式");
		textForm.setValue(roughOrdInf.getTrffcModName());

		ProcessInstanceInputVO.TextForm textForm11 = new ProcessInstanceInputVO.TextForm();
		textForm.setName("包装方式");
		textForm.setValue(roughOrdInf.getPackModName());

		ProcessInstanceInputVO.TextForm textForm12 = new ProcessInstanceInputVO.TextForm();
		textForm.setName("制单人");
		textForm.setValue(roughOrdInf.getCrtorName());

		ProcessInstanceInputVO.TextForm textForm13 = new ProcessInstanceInputVO.TextForm();
		textForm.setName("制单时间");
		textForm.setValue(roughOrdInf.getCrtorDT());

		ProcessInstanceInputVO.TextForm textForm14 = new ProcessInstanceInputVO.TextForm();
		textForm.setName("修改人");
		textForm.setValue(roughOrdInf.getMdferName());

		ProcessInstanceInputVO.TextForm textForm15 = new ProcessInstanceInputVO.TextForm();
		textForm.setName("修改时间");
		textForm.setValue(roughOrdInf.getMdfDT());

		ProcessInstanceInputVO.TextForm textForm16 = new ProcessInstanceInputVO.TextForm();
		textForm.setName("单据状态");
		textForm.setValue(roughOrdInf.getState());

		ProcessInstanceInputVO.TextForm textForm17 = new ProcessInstanceInputVO.TextForm();
		textForm.setName("备注");
		textForm.setValue(roughOrdInf.getRemark());

		//明细部分
		ProcessInstanceInputVO.TextForm textForm18 = new ProcessInstanceInputVO.TextForm();
		textForm.setName("成品编码");
		textForm.setValue(roughOrdInf.getProductCode());

		ProcessInstanceInputVO.TextForm textForm19 = new ProcessInstanceInputVO.TextForm();
		textForm.setName("成品名称");
		textForm.setValue(roughOrdInf.getProductName());

		ProcessInstanceInputVO.TextForm textForm20 = new ProcessInstanceInputVO.TextForm();
		textForm.setName("客户品名");
		textForm.setValue(roughOrdInf.getProName());

		ProcessInstanceInputVO.TextForm textForm21 = new ProcessInstanceInputVO.TextForm();
		textForm.setName("批号");
		textForm.setValue(roughOrdInf.getBatch());

		ProcessInstanceInputVO.TextForm textForm22 = new ProcessInstanceInputVO.TextForm();
		textForm.setName("规格");
		textForm.setValue(roughOrdInf.getSpec());

		ProcessInstanceInputVO.TextForm textForm23 = new ProcessInstanceInputVO.TextForm();
		textForm.setName("等级");
		textForm.setValue(roughOrdInf.getLeve());

		ProcessInstanceInputVO.TextForm textForm24 = new ProcessInstanceInputVO.TextForm();
		textForm.setName("克重");
		textForm.setValue(roughOrdInf.getFaw());

		ProcessInstanceInputVO.TextForm textForm25 = new ProcessInstanceInputVO.TextForm();
		textForm.setName("计价单位");
		textForm.setValue(roughOrdInf.getJjUnitName());

		ProcessInstanceInputVO.TextForm textForm26 = new ProcessInstanceInputVO.TextForm();
		textForm.setName("计价数量");
		textForm.setValue(roughOrdInf.getJjQty().toString());

		ProcessInstanceInputVO.TextForm textForm27 = new ProcessInstanceInputVO.TextForm();
		textForm.setName("单价");
		textForm.setValue(roughOrdInf.getPrice().toString());

		ProcessInstanceInputVO.TextForm textForm28 = new ProcessInstanceInputVO.TextForm();
		textForm.setName("税率");
		textForm.setValue(roughOrdInf.getTaxRate().toString());

		ProcessInstanceInputVO.TextForm textForm29 = new ProcessInstanceInputVO.TextForm();
		textForm.setName("不含税单价");
		textForm.setValue(roughOrdInf.getTaxprice().toString());

		ProcessInstanceInputVO.TextForm textForm30 = new ProcessInstanceInputVO.TextForm();
		textForm.setName("金额");
		textForm.setValue(roughOrdInf.getMoney().toString());

		ProcessInstanceInputVO.TextForm textForm31 = new ProcessInstanceInputVO.TextForm();
		textForm.setName("税额");
		textForm.setValue(roughOrdInf.getTaxMoney().toString());

		ProcessInstanceInputVO.TextForm textForm32 = new ProcessInstanceInputVO.TextForm();
		textForm.setName("不含税金额");
		textForm.setValue(roughOrdInf.getSumMoney().toString());

		ProcessInstanceInputVO.TextForm textForm33 = new ProcessInstanceInputVO.TextForm();
		textForm.setName("交货日期");
		textForm.setValue(roughOrdInf.getDeliveryDT());

		ProcessInstanceInputVO.TextForm textForm34 = new ProcessInstanceInputVO.TextForm();
		textForm.setName("物料来源");
		textForm.setValue(roughOrdInf.getMatSource());

		ProcessInstanceInputVO.TextForm textForm35 = new ProcessInstanceInputVO.TextForm();
		textForm.setName("备注");
		textForm.setValue(roughOrdInf.getRemarkC());

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
		textForms.add(textForm35);

		processInstance.setTextForms(textForms);
		return processInstance;
	}

	/**
	 * 执行的第一个方法
	 */
	public ServiceResult<String> startProcessInstance1() {
		try {
			DefaultDingTalkClient client = new DefaultDingTalkClient(URLConstant.URL_PROCESSINSTANCE_START);
			/**
			 * 在这里查询数据库，从数据库中拿到和钉钉对接的具体的所有人的数据，比如userId，userName，deptId等信息
			 * 可能需要查询所有的表，判断是否有数据
			 */
			//messageInfo表查询，测试用例
			int count = userService.selectUserCount();
				if(count>0){
				List<User> userList = userService.selectApproveUser();
				for(User user:userList){
					ProcessInstanceInputVO processInstance = UserMsg.getProcessInstanceInputVO(user);
					OapiProcessinstanceCreateRequest request = new OapiProcessinstanceCreateRequest();
					request.setProcessCode(Constant.PROCESS_CODE);
					request.setFormComponentValues(processInstance.generateForms());
					/**
					 * 如果想复用审批固定流程，使用或签会签的话，可以不传审批人，具体请参考文档： https://open-doc.dingtalk.com/microapp/serverapi2/ebkwx8
					 * 本次quickstart，演示不传审批人的场景
					 */
					//要和设计的相对应，审批人和抄送人什么的需要在这个进行传参
					//审批人设置 方闵：2936396644845660
					//	request.setApprovers("2936396644845660,173940214337028944");
					request.setApprovers(processInstance.getOriginatorUserId());
					request.setOriginatorUserId(processInstance.getOriginatorUserId());

					request.setDeptId(processInstance.getDeptId());
					//前面方闵，后面金超群
					//	request.setCcList("2936396644845660,173940214337028944");
					request.setCcList(processInstance.getOriginatorUserId());
					request.setCcPosition("FINISH");

					OapiProcessinstanceCreateResponse response = client.execute(request, AccessTokenUtil.getToken());

					if (response.getErrcode().longValue() != 0) {
						return ServiceResult.failure(String.valueOf(response.getErrorCode()), response.getErrmsg());
					}
					User user1 = new User();
					user1.setProcessInstanceId(response.getProcessInstanceId());
					user1.setId(user.getId());
					//在成功后回写数据库，将唯一的审批实例id写进去
					int updateProcessInstanceId = userService.updateProcessInstanceId(user1);
					if(updateProcessInstanceId>0){
						return ServiceResult.success(response.getProcessInstanceId());
					}else {
						return ServiceResult.failure(ServiceResultCode.SYS_ERROR.getErrCode(),ServiceResultCode.SYS_ERROR.getErrMsg());
					}
				}
			}else{
				bizLogger.info("未找到messageInfo表中的数据");
			}
		}catch (Exception e){
			String errLog = LogFormatter.getKVLogData(LogEvent.END,
					LogFormatter.KeyValue.getNew("processInstance", "出错了"));
			bizLogger.info(errLog,e);
			return ServiceResult.failure(ServiceResultCode.SYS_ERROR.getErrCode(),ServiceResultCode.SYS_ERROR.getErrMsg());
		}
		return ServiceResult.success("success");
	}


	/**
	 * 第二个方法
	 */
	public ServiceResult<String> startProcessInstance2(){
		try{

			DefaultDingTalkClient client = new DefaultDingTalkClient(URLConstant.URL_PROCESSINSTANCE_START);
			//testInfo表查询，也是测试
			int count1 = testService.selectTestCount();
			if(count1>0){
				List<Test> testList = testService.selectApproveTest();
				for(Test test:testList){
					ProcessInstanceInputVO processInstance = getProcessInstanceInputVOTest(test);
					OapiProcessinstanceCreateRequest request = new OapiProcessinstanceCreateRequest();
					request.setProcessCode(Constant.PRCESS_CODE_TEST);
					request.setFormComponentValues(processInstance.generateForms());
					/**
					 * 如果想复用审批固定流程，使用或签会签的话，可以不传审批人，具体请参考文档： https://open-doc.dingtalk.com/microapp/serverapi2/ebkwx8
					 * 本次quickstart，演示不传审批人的场景
					 */
					//要和设计的相对应，审批人和抄送人什么的需要在这个进行传参
					request.setApprovers(processInstance.getOriginatorUserId());
					request.setOriginatorUserId(processInstance.getOriginatorUserId());
					request.setDeptId(processInstance.getDeptId());
					request.setCcList(processInstance.getOriginatorUserId());
					request.setCcPosition("FINISH");

					OapiProcessinstanceCreateResponse response = client.execute(request, AccessTokenUtil.getToken());

					if (response.getErrcode().longValue() != 0) {
						return ServiceResult.failure(String.valueOf(response.getErrorCode()), response.getErrmsg());
					}
					Test test1 = new Test();
					test1.setProcessInstanceId(response.getProcessInstanceId());
					test1.setId(test.getId());
					//在成功后回写数据库，将唯一的审批实例id写进去
					int updateProcessInstanceId = testService.updateProcessInstanceIdTest(test1);
					if(updateProcessInstanceId>0){
						return ServiceResult.success(response.getProcessInstanceId());
					}else {
						return ServiceResult.failure(ServiceResultCode.SYS_ERROR.getErrCode(),ServiceResultCode.SYS_ERROR.getErrMsg());
					}
				}
			}else{
				bizLogger.info("未找到testInfo表中的数据");
			}
		}catch (Exception e){
			String errLog = LogFormatter.getKVLogData(LogEvent.END,
					LogFormatter.KeyValue.getNew("processInstance", "出错了"));
			bizLogger.info(errLog,e);
			return ServiceResult.failure(ServiceResultCode.SYS_ERROR.getErrCode(),ServiceResultCode.SYS_ERROR.getErrMsg());
		}
		return ServiceResult.success("success");
	}

	/**
	 * 坯布销售订单处理
	 */
	public ServiceResult<String> startProcessInstanceRoughOrdInf() {
		try {
			DefaultDingTalkClient client = new DefaultDingTalkClient(URLConstant.URL_PROCESSINSTANCE_START);
			/**
			 * 在这里查询数据库，从数据库中拿到和钉钉对接的具体的所有人的数据，比如userId，userName，deptId等信息
			 * 可能需要查询所有的表，判断是否有数据
			 */
			//查询坯布销售订单表中符合条件的数据
			int count = roughOrdInfService.selectRoughOrdInfCount();
			if(count>0){
				//查询对应的审核抄送等信息
				List<RoughOrdInf> roughOrdInfList = roughOrdInfService.selectApproveUser();
				for(RoughOrdInf roughOrdInf:roughOrdInfList){
					ProcessInstanceInputVO processInstance = RoughOrdInfMsg.getProcessInstanceInputVORoughOrdInf(roughOrdInf);
					OapiProcessinstanceCreateRequest request = new OapiProcessinstanceCreateRequest();
					request.setProcessCode(Constant.PRCESS_CODE_ROUGHORDINF);
					request.setFormComponentValues(processInstance.generateForms());

					//要和设计的相对应，审批人和抄送人什么的需要在这个进行传参
					//审批人设置 方闵：2936396644845660
					//	request.setApprovers("2936396644845660,173940214337028944");
					request.setApprovers(processInstance.getOriginatorUserId());
					request.setOriginatorUserId(processInstance.getOriginatorUserId());

					request.setDeptId(processInstance.getDeptId());
					//前面方闵，后面金超群,测试用
					//	request.setCcList("2936396644845660,173940214337028944");
					request.setCcList(processInstance.getOriginatorUserId());
					request.setCcPosition("FINISH");

					OapiProcessinstanceCreateResponse response = client.execute(request, AccessTokenUtil.getToken());

					if (response.getErrcode().longValue() != 0) {
						return ServiceResult.failure(String.valueOf(response.getErrorCode()), response.getErrmsg());
					}
					RoughOrdInf roughOrdInf1 = new RoughOrdInf();
					roughOrdInf1.setProcessInstanceId(response.getProcessInstanceId());
					//表中唯一确定这条数据的字段，id之类的
					roughOrdInf1.setId(roughOrdInf1.getId());
					//在成功后回写数据库，将唯一的审批实例id写进去
					int updateProcessInstanceId = roughOrdInfService.updateProcessInstanceIdRoughOrdInf(roughOrdInf1);
					if(updateProcessInstanceId>0){
						return ServiceResult.success(response.getProcessInstanceId());
					}else {
						return ServiceResult.failure(ServiceResultCode.SYS_ERROR.getErrCode(),ServiceResultCode.SYS_ERROR.getErrMsg());
					}
				}
			}else{
				bizLogger.info("未找到坯布销售订单表中的数据");
			}
		}catch (Exception e){
			String errLog = LogFormatter.getKVLogData(LogEvent.END,
					LogFormatter.KeyValue.getNew("processInstance", "出错了"));
			bizLogger.info(errLog,e);
			return ServiceResult.failure(ServiceResultCode.SYS_ERROR.getErrCode(),ServiceResultCode.SYS_ERROR.getErrMsg());
		}
		return ServiceResult.success("success");
	}
}


