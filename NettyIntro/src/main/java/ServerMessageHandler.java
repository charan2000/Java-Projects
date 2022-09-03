
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;

public class ServerMessageHandler extends ChannelInitializer<SocketChannel> {

    @Override
    protected void initChannel(SocketChannel socketChannel) {
        ChannelPipeline cp = socketChannel.pipeline();
        cp.addLast(new StringDecoder());
        cp.addLast(new StringEncoder());
        cp.addLast(new ChatServerHandler());
    }
}
