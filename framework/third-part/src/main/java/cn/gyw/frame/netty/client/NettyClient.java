// package cn.gyw.frame.netty.client;
//
// import java.util.concurrent.TimeUnit;
//
// import javax.annotation.PostConstruct;
//
// import org.slf4j.Logger;
// import org.slf4j.LoggerFactory;
//
// import io.netty.bootstrap.Bootstrap;
// import io.netty.buffer.Unpooled;
// import io.netty.channel.ChannelFuture;
// import io.netty.channel.ChannelFutureListener;
// import io.netty.channel.ChannelInitializer;
// import io.netty.channel.ChannelOption;
// import io.netty.channel.EventLoopGroup;
// import io.netty.channel.nio.NioEventLoopGroup;
// import io.netty.channel.socket.SocketChannel;
// import io.netty.channel.socket.nio.NioSocketChannel;
// import io.netty.util.CharsetUtil;
//
// @Component
// public class NettyClient {
//
// 	private static Logger log = LoggerFactory.getLogger(NettyClient.class);
//
// 	private EventLoopGroup group = new NioEventLoopGroup();
//
// 	@Value("${netty.host}")
// 	private String host;
//
// 	@Value("${netty.port}")
// 	private int port;
//
// 	private SocketChannel socketChannel;
//
// 	public void sendMsg(String message) {
// 		socketChannel.writeAndFlush(Unpooled.copiedBuffer(message, CharsetUtil.UTF_8));
// 	}
//
// 	@PostConstruct
// 	public void start() {
// 		Bootstrap bootstrap = new Bootstrap();
// 		bootstrap.group(group).channel(NioSocketChannel.class).remoteAddress(host, port)
// 				.option(ChannelOption.SO_KEEPALIVE, true).option(ChannelOption.TCP_NODELAY, true)
// 				.handler(new ChannelInitializer<SocketChannel>() {
// 					@Override
// 					protected void initChannel(SocketChannel channel) throws Exception {
//
// 					}
// 				});
// 		ChannelFuture future = bootstrap.connect();
// 		// 客户端断线重连逻辑
// 		future.addListener((ChannelFutureListener) future1 -> {
// 			if (future1.isSuccess()) {
// 				log.info("连接Netty服务端成功");
// 			} else {
// 				log.info("连接失败，进行断线重连");
// 				future1.channel().eventLoop().schedule(() -> start(), 20, TimeUnit.SECONDS);
// 			}
// 		});
// 		socketChannel = (SocketChannel) future.channel();
// 	}
// }
