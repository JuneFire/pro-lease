package com.design.lease.server;

import com.design.lease.handler.WebSocketServerHandler;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.http.HttpObjectAggregator;
import io.netty.handler.codec.http.HttpServerCodec;
import io.netty.handler.stream.ChunkedWriteHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class WebSocketServer {

	private static final Logger logger = LoggerFactory.getLogger(WebSocketServer.class);

	// websocket端口
	public static final int WEBSOCKET_PORT = 9090;

	public void run() throws Exception {
		EventLoopGroup bossGroup = new NioEventLoopGroup();
		EventLoopGroup workerGroup = new NioEventLoopGroup();
		try {
			ServerBootstrap b = new ServerBootstrap();
			b.group(bossGroup, workerGroup).channel(NioServerSocketChannel.class).childHandler(new ChannelInitializer() {

				@Override
				protected void initChannel(Channel channel) throws Exception {
					ChannelPipeline pipeline = channel.pipeline();
					pipeline.addLast("http-codec", new HttpServerCodec()); // Http消息编码解码
					pipeline.addLast("aggregator", new HttpObjectAggregator(65536)); // Http消息组装
					pipeline.addLast("http-chunked", new ChunkedWriteHandler()); // WebSocket通信支持
					pipeline.addLast("handler", new WebSocketServerHandler()); // WebSocket服务端Handler
				}
			});

			Channel channel = b.bind(WEBSOCKET_PORT).sync().channel();
			logger.info("WebSocket 已经启动，端口： {} .", WEBSOCKET_PORT);
			channel.closeFuture().sync();
		} finally {
			bossGroup.shutdownGracefully();
			workerGroup.shutdownGracefully();
		}
	}

}
