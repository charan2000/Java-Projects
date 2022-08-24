
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.util.CharsetUtil;

import java.nio.charset.Charset;


public class ChatClientHandler extends SimpleChannelInboundHandler<String> {

    public void channelActive(ChannelHandlerContext chc) {
//        chc.writeAndFlush(Unpooled.copiedBuffer("Netty is Buffed !\n", CharsetUtil.UTF_8));
//        chc.writeAndFlush(Unpooled.copiedBuffer("New Message ",CharsetUtil.UTF_8));
        chc.writeAndFlush("Hello Miami!");
        chc.writeAndFlush("Nice to meet u");
    }

    @Override
    protected void channelRead0(ChannelHandlerContext channelHandlerContext, String o) throws Exception {
        System.out.println("[Client-Received:] " + o);
    }

    public void exceptionCaught (ChannelHandlerContext chc, Throwable cause) {
        cause.printStackTrace();
        chc.close();
    }
}
