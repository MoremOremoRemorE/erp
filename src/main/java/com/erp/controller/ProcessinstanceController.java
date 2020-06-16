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
import com.erp.model.FormMsg.*;
import com.erp.service.*;
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

import java.util.List;


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
	@Autowired
	private RoughOddVaryInfService roughOddVaryInfService;
	@Autowired
	private RoughOddInfService roughOddInfService;
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
		/**
		 * 目前这边都是串行执行的，并行执行会出现重复发送的问题，多线程还没学会
		 */
		startProcessInstance1();
		startProcessInstance2();
		//坯布销售订单
		startProcessInstanceRoughOrdInf();
		//坯布采购变更单
		startProcessInstanceRoughOddVaryInf();




//		ExecutorService cachedThreadPool1 = Executors.newCachedThreadPool();
//		for (int i = 0; i < 10; i++) {
//			final int index = i;
//			try {
//				Thread.sleep(index * 1000);
//			} catch (InterruptedException e) {
//				e.printStackTrace();
//			}
//			cachedThreadPool1.execute(new Runnable() {
//				@Override
//				public void run() {
//					//查询的第一个测试数据
//					startProcessInstance2();
//				}
//			});
//		}
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
					ProcessInstanceInputVO processInstance = TestMsg.getProcessInstanceInputVOTest(test);
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

	/**
	 * 坯布采购变更单处理
	 */
	public ServiceResult<String> startProcessInstanceRoughOddVaryInf() {
		try {
			DefaultDingTalkClient client = new DefaultDingTalkClient(URLConstant.URL_PROCESSINSTANCE_START);
			/**
			 * 在这里查询数据库，从数据库中拿到和钉钉对接的具体的所有人的数据，比如userId，userName，deptId等信息
			 * 可能需要查询所有的表，判断是否有数据
			 */
			//查询坯布采购变更单表中符合条件的数据
			int count = roughOddVaryInfService.selectRoughOddVaryInfCount();
			if(count>0){
				//查询对应的审核抄送等信息
				List<RoughOddVaryInf> roughOddVaryInfList = roughOddVaryInfService.selectApproveUser();
				for(RoughOddVaryInf roughOddVaryInf:roughOddVaryInfList){
					ProcessInstanceInputVO processInstance = RoughOddVaryInfMsg.getProcessInstanceInputVORoughOddVaryInf(roughOddVaryInf);
					OapiProcessinstanceCreateRequest request = new OapiProcessinstanceCreateRequest();
					request.setProcessCode(Constant.PRCESS_CODE_ROUGHODDVARYINF);
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
					RoughOddVaryInf roughOddVaryInf1 = new RoughOddVaryInf();
					roughOddVaryInf1.setProcessInstanceId(response.getProcessInstanceId());
					//表中唯一确定这条数据的字段，id之类的
					roughOddVaryInf1.setId(roughOddVaryInf.getId());
					//在成功后回写数据库，将唯一的审批实例id写进去
					int updateProcessInstanceId = roughOddVaryInfService.updateProcessInstanceIdRoughOddVaryInf(roughOddVaryInf1);
					if(updateProcessInstanceId>0){
						return ServiceResult.success(response.getProcessInstanceId());
					}else {
						return ServiceResult.failure(ServiceResultCode.SYS_ERROR.getErrCode(),ServiceResultCode.SYS_ERROR.getErrMsg());
					}
				}
			}else{
				bizLogger.info("未找到坯布采购变更表中的数据");
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
	 * 坯布采购订单处理
	 */
	public ServiceResult<String> startProcessInstanceRoughOddInf() {
		try {
			DefaultDingTalkClient client = new DefaultDingTalkClient(URLConstant.URL_PROCESSINSTANCE_START);
			/**
			 * 在这里查询数据库，从数据库中拿到和钉钉对接的具体的所有人的数据，比如userId，userName，deptId等信息
			 * 可能需要查询所有的表，判断是否有数据
			 */
			//查询坯布采购变更单表中符合条件的数据
			int count = roughOddInfService.selectRoughOddInfCount();
			if(count>0){
				//查询对应的审核抄送等信息
				List<RoughOddInf> roughOddInfList = roughOddInfService.selectApproveUser();
				for(RoughOddInf roughOddInf:roughOddInfList){
					ProcessInstanceInputVO processInstance = RoughOddInfMsg.getProcessInstanceInputVORoughOddInf(roughOddInf);
					OapiProcessinstanceCreateRequest request = new OapiProcessinstanceCreateRequest();
					request.setProcessCode(Constant.PRCESS_CODE_ROUGHODDINF);
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
					RoughOddInf roughOddInf1 = new RoughOddInf();
					roughOddInf1.setProcessInstanceId(response.getProcessInstanceId());
					//表中唯一确定这条数据的字段，id之类的
					roughOddInf1.setId(roughOddInf.getId());
					//在成功后回写数据库，将唯一的审批实例id写进去
					int updateProcessInstanceId = roughOddInfService.updateProcessInstanceIdRoughOddInf(roughOddInf1);
					if(updateProcessInstanceId>0){
						return ServiceResult.success(response.getProcessInstanceId());
					}else {
						return ServiceResult.failure(ServiceResultCode.SYS_ERROR.getErrCode(),ServiceResultCode.SYS_ERROR.getErrMsg());
					}
				}
			}else{
				bizLogger.info("未找到坯布采购订单表中的数据");
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


