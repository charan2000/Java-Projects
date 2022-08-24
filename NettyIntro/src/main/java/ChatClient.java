
import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetSocketAddress;
import java.util.concurrent.TimeUnit;

public class ChatClient {

//    private final String host;
//    private final int port;
//
//
//    public ChatClient(String host, int port) {
//        this.host = host;
//        this.port = port;
//    }

    public static void main(String[] args) throws InterruptedException {

        EventLoopGroup group = new NioEventLoopGroup();
        try {
            Bootstrap bootstrap = new Bootstrap()
                    .group(group)
                    .channel(NioSocketChannel.class)
                    .handler(new ChatClientInitializer())
                    .remoteAddress(new InetSocketAddress("localhost", 9999));

            ChannelFuture channel = bootstrap.connect().sync().channel().closeFuture().sync();
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        }
        finally {
            group.shutdownGracefully();
        }
    }
}
