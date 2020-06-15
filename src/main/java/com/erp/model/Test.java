package com.erp.model;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class Test implements Serializable {

    private int id;
    private String time;
    private String message;
    private String money;
    private String userId;
    private String userName;
    private Long deptId;
    private String status;
    private String processInstanceId;
}
