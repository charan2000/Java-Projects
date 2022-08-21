
import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;
import java.net.InetSocketAddress;

public class ChatClient {

//    private final String host;
//    private final int port;
//
//
//    public ChatClient(String host, int port) {
//        this.host = host;
//        this.port = port;
//    }

    public static void main(String[] args) {

        EventLoopGroup group = new NioEventLoopGroup();
        try {
            Bootstrap bootstrap = new Bootstrap()
                    .group(group)
                    .channel(NioSocketChannel.class)
                    .handler(new ChatClientInitializer())
                    .remoteAddress(new InetSocketAddress("localhost", 9999));

            ChannelFuture channel = bootstrap.connect().sync().channel().closeFuture().sync();
//            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

//            while (true) {
//                channel.write(br.readLine());
//            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            group.shutdownGracefully();
        }

    }
}
