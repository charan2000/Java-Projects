
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.util.CharsetUtil;

import java.nio.charset.Charset;


public class ChatClientHandler extends SimpleChannelInboundHandler<Object> {

    public void channelActive(ChannelHandlerContext chc) {
        chc.writeAndFlush(Unpooled.copiedBuffer(" Netty is Buffed !", CharsetUtil.UTF_8));
    }

    @Override
    protected void channelRead0(ChannelHandlerContext channelHandlerContext, Object o) throws Exception {

        ByteBuf intByte = (ByteBuf) o;

        System.out.println("[Client-Received:] " + intByte.toString(CharsetUtil.UTF_8));
    }

    public void exceptionCaught (ChannelHandlerContext chc, Throwable cause) {
        cause.printStackTrace();
        chc.close();
    }
}
