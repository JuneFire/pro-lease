package com.design.lease.request;

import com.design.lease.message.Message;


public class ChatReqMsg extends Message{

	private String serviceId;

	private Long uid;

	public String getServiceId() {
		return serviceId;
	}

	public void setServiceId(String serviceId) {
		this.serviceId = serviceId;
	}

	public Long getUid() {
		return uid;
	}

	public void setUid(Long uid) {
		this.uid = uid;
	}
}
