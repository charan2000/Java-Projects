

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;

public class ServerProgram {

    private static final int port = 9989;

    public static void main(String[] args) throws InterruptedException {

        EventLoopGroup masterGrp = new NioEventLoopGroup();
        EventLoopGroup workerGrp = new NioEventLoopGroup();

        try {
            ServerBootstrap serverBootstrap = new ServerBootstrap();
            serverBootstrap.group(masterGrp, workerGrp)
                    .channel(NioServerSocketChannel.class).childHandler(new ServerMessageHandler());

            ChannelFuture channelFuture = serverBootstrap.bind(port).sync();
            System.out.println("Chat server started:");
            channelFuture.channel().closeFuture().sync();
        }
        finally {
            masterGrp.shutdownGracefully();
            workerGrp.shutdownGracefully();
        }
    }


}
