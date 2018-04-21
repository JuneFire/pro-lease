package com.design.lease.bo;

import lombok.Data;
import java.io.Serializable;

@Data
public class UserDetailBO implements Serializable{

    private static final long serialVersionUID = -6176610310742701438L;

    private Long uid;

    private String uname;

    private Long amount;

    private String iphone;

    private String email;

}
