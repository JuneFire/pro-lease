package com.design.lease.manager;

import io.netty.channel.Channel;
import io.netty.handler.codec.http.websocketx.TextWebSocketFrame;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.ConcurrentHashMap;

public class SessionManager {

	private static final Logger logger = LoggerFactory.getLogger(SessionManager.class.getName());

	private ConcurrentHashMap<Long, Channel> sessionMap = new ConcurrentHashMap<>();

	private Object lock = new Object();

	public static final SessionManager _ins = new SessionManager();

	public static SessionManager getSession() {
		return _ins;
	}

	private SessionManager() {

	}

	public Channel getSession(Long uid) {
		return sessionMap.get(uid);
	}

	public void putSession(Long uid, Channel channel) {
		if (sessionMap.get(uid) != null) {
			return;
		}
		sessionMap.put(uid, channel);
	}

	public void removeSession(Long uid) {
		sessionMap.remove(uid);
	}

	public void removeSession(Channel channel) {

		ConcurrentHashMap<Long, Channel> map = null;

		synchronized (lock) {
			map = sessionMap;
		}

		for (Long uid : map.keySet()) {
			if (channel == map.get(uid)) {
				map.remove(uid);
			}
		}

		sessionMap = map;
	}

	public void sendMessage(Long uid, String message) throws Exception{
		Channel channel = getSession(uid);
		if (channel == null || !channel.isWritable()) {
			logger.error("当前session处于关闭状态,无法推送消息.uid = {},message = {}", uid, message);
			throw new Exception("sendMessage异常.");
		}
		channel.write(new TextWebSocketFrame(message));
	}
}
