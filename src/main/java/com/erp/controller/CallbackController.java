package com.erp.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.erp.config.Constant;
import com.erp.config.URLConstant;
import com.dingtalk.api.DefaultDingTalkClient;
import com.dingtalk.api.DingTalkClient;
import com.dingtalk.api.request.OapiCallBackDeleteCallBackRequest;
import com.dingtalk.api.request.OapiCallBackRegisterCallBackRequest;
import com.dingtalk.api.response.OapiCallBackRegisterCallBackResponse;
import com.dingtalk.oapi.lib.aes.DingTalkEncryptor;
import com.dingtalk.oapi.lib.aes.Utils;
import com.erp.model.RoughOrdInf;
import com.erp.model.Test;
import com.erp.model.User;
import com.erp.service.RoughOddVaryInfService;
import com.erp.service.RoughOrdInfService;
import com.erp.service.TestService;
import com.erp.service.UserService;
import com.erp.util.AccessTokenUtil;
import com.erp.util.MessageUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Map;

/**
 * E应用回调信息处理
 */
@RestController
public class CallbackController {

    @Autowired
    private UserService userService;
    @Autowired
    private TestService testService;
    @Autowired
    private RoughOrdInfService roughOrdInfService;
    @Autowired
    private RoughOddVaryInfService roughOddVaryInfService;

    private static final Logger bizLogger = LoggerFactory.getLogger("BIZ_CALLBACKCONTROLLER");
    private static final Logger mainLogger = LoggerFactory.getLogger(com.erp.controller.CallbackController.class);

    /**
     * 创建套件后，验证回调URL创建有效事件（第一次保存回调URL之前）
     */
    private static final String CHECK_URL = "check_url";

    /**
     * 审批任务回调
     */
    private static final String BPMS_TASK_CHANGE = "bpms_task_change";

    /**
     * 审批实例回调
     */
    private static final String BPMS_INSTANCE_CHANGE = "bpms_instance_change";

    /**
     * 相应钉钉回调时的值
     */
    private static final String CALLBACK_RESPONSE_SUCCESS = "success";


    @RequestMapping(value = "/callback", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, String> callback(@RequestParam(value = "signature", required = false) String signature,
                                        @RequestParam(value = "timestamp", required = false) String timestamp,
                                        @RequestParam(value = "nonce", required = false) String nonce,
                                        @RequestBody(required = false) JSONObject json) {
        String params = " signature:"+signature + " timestamp:"+timestamp +" nonce:"+nonce+" json:"+json;
        try {
            DingTalkEncryptor dingTalkEncryptor = new DingTalkEncryptor(Constant.TOKEN, Constant.ENCODING_AES_KEY,Constant.CORP_ID);
            //从post请求的body中获取回调信息的加密数据进行解密处理
            String encryptMsg = json.getString("encrypt");
            String plainText = dingTalkEncryptor.getDecryptMsg(signature, timestamp, nonce, encryptMsg);
            JSONObject obj = JSON.parseObject(plainText);
            // 根据回调数据类型做不同的业务处理
            //当前的审批id
            String processInstanceId=obj.getString("processInstanceId");
            //开始：start；完成：finish；
            String type=obj.getString("type");
            //审批结果。同意：agree;拒绝：refuse;转送：redirect(当前值只有bpms_task_change能够接收到)
            String result=obj.getString("result");

            //异步业务操作，防止响应时间过长，钉钉重复推送回调。(后期想一下用多线程怎么实现)
            //根据回调数据类型做不同的业务处理
            String eventType = obj.getString("EventType");
            if (eventType!=null&&!"check_url".equals(eventType) && "bpms_instance_change".equals(eventType)) {
                switch (obj.getString("processCode")) {
                    //第一个测试模板
                    case Constant.PROCESS_CODE:
                        bizLogger.info("-------------------------开始回写数据库---------------------------------------");
                        Boolean bool = userService.returnResult(plainText);
                        if(bool){
                            bizLogger.info("回写数据库成功");
                        }else {
                            bizLogger.info("回写数据库失败");
                        }
                        bizLogger.info("-------------------------回写数据库结束---------------------------------------");
                        break;
                    case Constant.PRCESS_CODE_TEST:
                        //测试模板二
                        bizLogger.info("-------------------------开始回写数据库--TEST---------------------------------------");
                        Boolean bool1 = testService.returnResult(plainText);
                        if(bool1){
                            bizLogger.info("回写数据库成功--TEST");
                        }else {
                            bizLogger.info("回写数据库失败--TEST");
                        }
                        bizLogger.info("-------------------------回写数据库结束--TEST--------------------------------------");
                        break;
                    case Constant.PRCESS_CODE_ROUGHORDINF:
                          //坯布销售订单
                          bizLogger.info("-------------------------开始回写数据库--坯布销售订单---------------------------------------");
                          Boolean bool2 = roughOrdInfService.returnResult(plainText);
                          if(bool2){
                              bizLogger.info("回写数据库成功--坯布销售订单");
                          }else {
                              bizLogger.info("回写数据库失败--坯布销售订单");
                          }
                          bizLogger.info("-------------------------回写数据库结束--坯布销售订单--------------------------------------");
                        break;
                    case Constant.PRCESS_CODE_ROUGHODDVARYINF:
                        //坯布采购变更单
                        bizLogger.info("-------------------------开始回写数据库--坯布采购变更单---------------------------------------");
                        Boolean bool3 = roughOddVaryInfService.returnResult(plainText);
                        if(bool3){
                            bizLogger.info("回写数据库成功--坯布采购变更单");
                        }else {
                            bizLogger.info("回写数据库失败--坯布采购变更单");
                        }
                        bizLogger.info("-------------------------回写数据库结束--坯布采购变更单--------------------------------------");
                        break;
                    default:
                        break;
                }
            } else {
                bizLogger.info("^_^--审批任务回调--^_^");
            }
            // 返回success的加密信息表示回调处理成功
            return dingTalkEncryptor.getEncryptedMap(CALLBACK_RESPONSE_SUCCESS, System.currentTimeMillis(), Utils.getRandomStr(8));
        } catch (Exception e) {
            //失败的情况，应用的开发者应该通过告警感知，并干预修复
            mainLogger.error("process callback failed！"+params,e);
            return null;
        }

    }

    public static void main(String[] args) throws Exception{
        // 先删除企业已有的回调
        DingTalkClient client = new DefaultDingTalkClient(URLConstant.DELETE_CALLBACK);
        OapiCallBackDeleteCallBackRequest request = new OapiCallBackDeleteCallBackRequest();
        request.setHttpMethod("GET");
        client.execute(request, AccessTokenUtil.getToken());

        // 重新为企业注册回调
        client = new DefaultDingTalkClient(URLConstant.REGISTER_CALLBACK);
        OapiCallBackRegisterCallBackRequest registerRequest = new OapiCallBackRegisterCallBackRequest();
        registerRequest.setUrl(Constant.CALLBACK_URL_HOST + "/callback");
        registerRequest.setAesKey(Constant.ENCODING_AES_KEY);
        registerRequest.setToken(Constant.TOKEN);
        registerRequest.setCallBackTag(Arrays.asList("bpms_instance_change","bpms_task_change"));
        OapiCallBackRegisterCallBackResponse registerResponse = client.execute(registerRequest,AccessTokenUtil.getToken());
        if (registerResponse.isSuccess()) {
            System.out.println("回调注册成功了！！！");
        }
    }
}
