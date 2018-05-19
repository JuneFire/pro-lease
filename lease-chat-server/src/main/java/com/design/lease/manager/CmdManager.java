package com.design.lease.manager;

import com.design.lease.annotation.Cmd;
import com.design.lease.cmd.BaseCmd;
import com.design.lease.constant.CmdCode;
import com.design.lease.message.ChatMessage;
import com.design.lease.request.RegReqMsg;
import io.netty.buffer.ByteBufAllocator;
import io.netty.channel.*;
import io.netty.util.Attribute;
import io.netty.util.AttributeKey;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;
import java.net.SocketAddress;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CmdManager {

	private static final Logger logger = LoggerFactory.getLogger(CmdManager.class);

	private Map<String, BaseCmd> cmdMap = new HashMap<>();

	private static final CmdManager _ins = new CmdManager();

	public static CmdManager getCmdManager(){
		return _ins;
	}

	private CmdManager(){
	}

	public void init() {
		try {
			Class<?> cls = Class.forName(BaseCmd.class.getName());
			List<Class<?>> classes = new ArrayList<>();
			for (Class<?> c : getClasses(cls)) {
				if (cls.isAssignableFrom(c) && !cls.equals(c) && c.isAnnotationPresent(Cmd.class)) {
					classes.add(c);
					Cmd cmd = c.getAnnotation(Cmd.class);
					String code = cmd.code();
					if (cmdMap.containsKey(cmd.code())) {
						logger.info("有重复的协议号.CODE = {}", code);
						throw new Exception("重复协议号异常.");
					}
					BaseCmd baseCmd = (BaseCmd) c.newInstance();
					cmdMap.put(code, baseCmd);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public BaseCmd getCmd(String code) {
		if (cmdMap.containsKey(code)) {
			return cmdMap.get(code);
		}
		return null;
	}

	/**
	 * 取得当前类路径下的所有类
	 *
	 * @param cls
	 * @return
	 * @throws IOException
	 * @throws ClassNotFoundException
	 */
	public List<Class<?>> getClasses(Class<?> cls) throws IOException,
			ClassNotFoundException {
		String pk = cls.getPackage().getName();
		String path = pk.replace('.', '/');
		ClassLoader classloader = Thread.currentThread().getContextClassLoader();
		URL url = classloader.getResource(path);
		return getClasses(new File(url.getFile()), pk);
	}

	/**
	 * 迭代查找类
	 *
	 * @param dir
	 * @param pk
	 * @return
	 * @throws ClassNotFoundException
	 */
	private List<Class<?>> getClasses(File dir, String pk) throws ClassNotFoundException {
		List<Class<?>> classes = new ArrayList<Class<?>>();
		if (!dir.exists()) {
			return classes;
		}
		for (File f : dir.listFiles()) {
			if (f.isDirectory()) {
				classes.addAll(getClasses(f, pk + "." + f.getName()));
			}
			String name = f.getName();
			if (name.endsWith(".class")) {
				classes.add(Class.forName(pk + "." + name.substring(0, name.length() - 6)));
			}
		}
		return classes;
	}

	public static void main(String[] args) {
		CmdManager.getCmdManager().init();
		BaseCmd baseCmd = CmdManager.getCmdManager().getCmd(CmdCode.CMD_REG);
		ChatMessage chatMessage = new ChatMessage();
		chatMessage.setUid(10000L);
		chatMessage.setMessage("测试");
		RegReqMsg regReqMsg = new RegReqMsg();
		regReqMsg.setUid(10000L);
		regReqMsg.setMessage("测试");
		try {
			baseCmd.doCmd(regReqMsg, new Channel() {
				@Override
				public ChannelId id() {
					return null;
				}

				@Override
				public EventLoop eventLoop() {
					return null;
				}

				@Override
				public Channel parent() {
					return null;
				}

				@Override
				public ChannelConfig config() {
					return null;
				}

				@Override
				public boolean isOpen() {
					return false;
				}

				@Override
				public boolean isRegistered() {
					return false;
				}

				@Override
				public boolean isActive() {
					return false;
				}

				@Override
				public ChannelMetadata metadata() {
					return null;
				}

				@Override
				public SocketAddress localAddress() {
					return null;
				}

				@Override
				public SocketAddress remoteAddress() {
					return null;
				}

				@Override
				public ChannelFuture closeFuture() {
					return null;
				}

				@Override
				public boolean isWritable() {
					return false;
				}

				@Override
				public Unsafe unsafe() {
					return null;
				}

				@Override
				public ChannelPipeline pipeline() {
					return null;
				}

				@Override
				public ByteBufAllocator alloc() {
					return null;
				}

				@Override
				public ChannelPromise newPromise() {
					return null;
				}

				@Override
				public ChannelProgressivePromise newProgressivePromise() {
					return null;
				}

				@Override
				public ChannelFuture newSucceededFuture() {
					return null;
				}

				@Override
				public ChannelFuture newFailedFuture(Throwable cause) {
					return null;
				}

				@Override
				public ChannelPromise voidPromise() {
					return null;
				}

				@Override
				public ChannelFuture bind(SocketAddress localAddress) {
					return null;
				}

				@Override
				public ChannelFuture connect(SocketAddress remoteAddress) {
					return null;
				}

				@Override
				public ChannelFuture connect(SocketAddress remoteAddress, SocketAddress localAddress) {
					return null;
				}

				@Override
				public ChannelFuture disconnect() {
					return null;
				}

				@Override
				public ChannelFuture close() {
					return null;
				}

				@Override
				public ChannelFuture deregister() {
					return null;
				}

				@Override
				public ChannelFuture bind(SocketAddress localAddress, ChannelPromise promise) {
					return null;
				}

				@Override
				public ChannelFuture connect(SocketAddress remoteAddress, ChannelPromise promise) {
					return null;
				}

				@Override
				public ChannelFuture connect(SocketAddress remoteAddress, SocketAddress localAddress, ChannelPromise promise) {
					return null;
				}

				@Override
				public ChannelFuture disconnect(ChannelPromise promise) {
					return null;
				}

				@Override
				public ChannelFuture close(ChannelPromise promise) {
					return null;
				}

				@Override
				public ChannelFuture deregister(ChannelPromise promise) {
					return null;
				}

				@Override
				public Channel read() {
					return null;
				}

				@Override
				public ChannelFuture write(Object msg) {
					return null;
				}

				@Override
				public ChannelFuture write(Object msg, ChannelPromise promise) {
					return null;
				}

				@Override
				public Channel flush() {
					return null;
				}

				@Override
				public ChannelFuture writeAndFlush(Object msg, ChannelPromise promise) {
					return null;
				}

				@Override
				public ChannelFuture writeAndFlush(Object msg) {
					return null;
				}

				@Override
				public <T> Attribute<T> attr(AttributeKey<T> key) {
					return null;
				}

				@Override
				public <T> boolean hasAttr(AttributeKey<T> key) {
					return false;
				}

				@Override
				public int compareTo(Channel o) {
					return 0;
				}
			});
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
