package com.design.lease.message;

import java.io.Serializable;

public class HeadMessage implements Serializable{
    private static final long serialVersionUID = 2680133831924288138L;

    private String serviceId;

    public String getServiceId() {
        return serviceId;
    }

    public void setServiceId(String serviceId) {
        this.serviceId = serviceId;
    }
}
