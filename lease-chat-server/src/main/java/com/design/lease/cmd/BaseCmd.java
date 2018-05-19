package com.design.lease.cmd;

import com.design.lease.manager.SessionManager;
import com.design.lease.message.Message;
import io.netty.channel.Channel;

public abstract class BaseCmd {

	public abstract void doCmd(Message message, Channel channel) throws Exception;

	public abstract Class getReqClass() throws Exception;

	public void sendMessage(Long uid,String message) throws Exception {

		SessionManager.getSession().sendMessage(uid,message);

	}

}
