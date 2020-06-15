package com.erp.model;


import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * 仅供搭建项目初期测试
 */

@Getter
@Setter
public class User implements Serializable {

    private Long id;
    private String UserId;
    private String userName;
    private Long deptId;
    private String time;
    private String renshu;
    private String jine;
    private String tongban;
    private String jttools;
    private String ccshiyou;
    private String status;
    /**
     * 回写的审批实例id
     */
    private String processInstanceId;

}
