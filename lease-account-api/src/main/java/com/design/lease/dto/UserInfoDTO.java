package com.design.lease.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class UserInfoDTO implements Serializable{
    private static final long serialVersionUID = -2934379819434512942L;

    private Long uid;

    private String uname;

}
