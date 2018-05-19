package com.design.lease.request;

import com.design.lease.message.Message;


public class RegReqMsg extends Message{

	private Long uid;

	public Long getUid() {
		return uid;
	}

	public void setUid(Long uid) {
		this.uid = uid;
	}
}
