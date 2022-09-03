
import io.netty.bootstrap.Bootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;

import java.util.Scanner;

public class ClientProgram {

    private static final String ip = "127.0.0.1" ;
    private static final int port = 9989;

    public static void main(String[] args) throws InterruptedException {

        Scanner sc = new Scanner(System.in);

        EventLoopGroup group = new NioEventLoopGroup();

        try {
            Bootstrap btsrp = new Bootstrap();

            btsrp.group(group)
                    .channel(NioSocketChannel.class)
                    .handler(new ClientMessageHandler());

            ChannelFuture channelFuture = btsrp.connect(ip, port).sync();

            while (sc.hasNext()) {
                String input = sc.nextLine();
                Channel channel = channelFuture.sync().channel();
                channel.writeAndFlush("Client Name: " + input);
                channel.flush();
            }
            channelFuture.channel().closeFuture().sync();
        }
        finally {
            group.shutdownGracefully();
        }
    }
}