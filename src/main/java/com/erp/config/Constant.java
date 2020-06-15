package com.erp.config;

import com.erp.util.CodeUtil;

/**
 * 项目中的常量定义类
 */
public class Constant {
    /**
     * 企业corpid, 需要修改成开发者所在企业
     */
    public static final String CORP_ID = "ding88cb56e0b610cc5135c2f4657eb6378f";
    /**
     * 应用的AppKey，登录开发者后台，点击应用管理，进入应用详情可见
     */
    public static final String APPKEY = "dingnaxq7mrghvy8yhty";
    /**
     * 应用的AppSecret，登录开发者后台，点击应用管理，进入应用详情可见
     */
    public static final String APPSECRET = "2VUaFkLs72GPCQXjbtF3oLf6DCT6MZuir5h0aIlNFU0x-zufM9aY986YPgwjoZtx";

    /**
     * 数据加密密钥。用于回调数据的加密，长度固定为43个字符，从a-z, A-Z, 0-9共62个字符中选取,您可以随机生成
     */
    public static final String ENCODING_AES_KEY = "AQTpnmJSz3nETNpFakBdPVCUrdrxL5Hv899PRHAgSMJ";

    /**
     * 加解密需要用到的token，企业可以随机填写。如 "12345"
     */
    public static final String TOKEN = "35541";

    /**
     * 应用的agentdId，登录开发者后台可查看
     */
    public static final Long AGENTID = Long.valueOf(800893428);

    /**
     * 审批模板唯一标识，可以在审批管理后台找到
     * 当前是测试
     */
    public static final String PROCESS_CODE = "PROC-F9FC101A-844C-400C-B585-A22BE58BDC66";

    /**
     * 测试模板二
     */
    public static final String PRCESS_CODE_TEST ="PROC-19FE5E84-6ADE-4B58-B28A-2D1CF740D0EF";

    /**
     * 坯布销售订单
     */
    public static final String PRCESS_CODE_ROUGHORDINF ="PROC-166BF5C9-2999-41CF-BA61-43901FB40ED7";
    /**
     * 回调host
     */
    public static final String CALLBACK_URL_HOST = "http://erpjxc.vaiwan.com";
}
