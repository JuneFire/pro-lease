package com.design.lease.service;

import com.design.lease.cmd.BaseCmd;
import com.design.lease.constant.CmdCode;
import com.design.lease.manager.CmdManager;
import com.design.lease.manager.SessionManager;
import com.design.lease.message.HeadMessage;
import com.design.lease.message.Message;
import com.design.lease.utils.JacksonObjectUtils;
import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.http.websocketx.CloseWebSocketFrame;
import io.netty.handler.codec.http.websocketx.TextWebSocketFrame;
import io.netty.handler.codec.http.websocketx.WebSocketFrame;
import org.apache.commons.lang.StringUtils;
import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.map.ObjectMapper;

public class WebSocketService {

	public static void doHandler(ChannelHandlerContext channelHandlerContext, WebSocketFrame socketFrame) throws Exception {
		TextWebSocketFrame textWebSocketFrame = (TextWebSocketFrame) socketFrame;
		ObjectMapper mapper = JacksonObjectUtils.getMapper();
		JsonNode root = mapper.readTree(textWebSocketFrame.text());
		JsonNode bodyNode = root.path("body");
		JsonNode headNode = root.path("head");
		Object head = mapper.readValue(String.valueOf(headNode), HeadMessage.class);
		HeadMessage headMessage = (HeadMessage) head;
		if(headMessage == null || StringUtils.isEmpty(headMessage.getServiceId())){
			throw new Exception("执行channel错误,code等于null");
		}
		String code = headMessage.getServiceId();
		BaseCmd baseCmd = CmdManager.getCmdManager().getCmd(code);
		if(baseCmd == null){
			throw new Exception("执行channel错误,baseCmd等于null");
		}
		Object body = mapper.readValue(String.valueOf(bodyNode), baseCmd.getReqClass());
		baseCmd.doCmd((Message) body,channelHandlerContext.channel());
	}

	public static void close(Channel channel, CloseWebSocketFrame frame) {
		channel.close();
		SessionManager.getSession().removeSession(channel);
	}

}
