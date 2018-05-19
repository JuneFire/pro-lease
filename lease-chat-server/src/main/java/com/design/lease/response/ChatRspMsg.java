package com.design.lease.response;

import com.design.lease.message.Message;

public class ChatRspMsg extends Message{

	private Long uid;

	public Long getUid() {
		return uid;
	}

	public void setUid(Long uid) {
		this.uid = uid;
	}
}
