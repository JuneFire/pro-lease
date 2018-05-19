package com.design.lease;

import com.design.lease.manager.CmdManager;
import com.design.lease.server.WebSocketServer;
import com.design.lease.service.WebSocketService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class WebSocketStart {

	private static final Logger logger = LoggerFactory.getLogger(WebSocketStart.class);

	public static void main(String[] args){
		try {
			CmdManager.getCmdManager().init();
			new WebSocketServer().run();
			logger.info("启动聊天服务器正常.");
		} catch (Exception e) {
			logger.info("启动服务器异常.",e);
		}
	}

}
