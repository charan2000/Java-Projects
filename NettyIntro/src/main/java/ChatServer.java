import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;

import java.net.InetSocketAddress;

public class ChatServer {

    private static final int port = 9999;
    public static void main(String[] args) throws InterruptedException {

        EventLoopGroup masterGroup = new NioEventLoopGroup();
        EventLoopGroup userGroup = new NioEventLoopGroup();
        try{
            ServerBootstrap serverBootstrap = new ServerBootstrap()
                    .group(masterGroup,userGroup)
                    .channel(NioServerSocketChannel.class)
                    .childHandler(new ChatServerInitializer());

            serverBootstrap.bind(9999).sync()
                    .channel().closeFuture().sync();

            ChannelFuture ch = serverBootstrap.bind(port).sync();
            ch.channel().closeFuture().sync();
        }
        finally {
            masterGroup.shutdownGracefully();
            userGroup.shutdownGracefully();
        }

    }

}
