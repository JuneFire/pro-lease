package com.design.lease.cmd;

import com.design.lease.annotation.Cmd;
import com.design.lease.constant.CmdCode;
import com.design.lease.message.ChatMessage;
import com.design.lease.message.Message;
import io.netty.channel.Channel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Cmd(code = CmdCode.CMD_CHAT, param = ChatMessage.class)
public class ChatCmd extends BaseCmd {

	private static final Logger logger = LoggerFactory.getLogger(ChatCmd.class.getName());

	@Override
	public void doCmd(Message message, Channel channel) throws Exception {
		logger.info("message = {}", message);
		ChatMessage chatMessage = (ChatMessage) message;
		logger.info("message = {},uid = {}", chatMessage.getMessage(), chatMessage.getUid());
		this.sendMessage(chatMessage.getUid(), chatMessage.getMessage());
	}

	@Override
	public Class getReqClass() throws Exception {
		return ChatMessage.class;
	}
}
