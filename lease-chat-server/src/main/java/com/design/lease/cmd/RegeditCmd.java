package com.design.lease.cmd;

import com.design.lease.annotation.Cmd;
import com.design.lease.constant.CmdCode;
import com.design.lease.manager.SessionManager;
import com.design.lease.message.Message;
import com.design.lease.request.RegReqMsg;
import io.netty.channel.Channel;

@Cmd(code = CmdCode.CMD_REG,param = RegReqMsg.class)
public class RegeditCmd extends BaseCmd{

	@Override
	public void doCmd(Message message, Channel channel) throws Exception {
		RegReqMsg reqMsg = (RegReqMsg) message;
		SessionManager.getSession().putSession(reqMsg.getUid(),channel);
		this.sendMessage(reqMsg.getUid(),"登录成功!");
	}

	@Override
	public Class getReqClass() throws Exception {
		return RegReqMsg.class;
	}

}
