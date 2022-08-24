import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.*;
import io.netty.util.CharsetUtil;

public class ChatServerHandler extends ChannelInboundHandlerAdapter {

//    private static final ChannelGroup channels = new DefaultChannelGroup();

    @Override
    public void channelRead(ChannelHandlerContext chc, Object msg) throws Exception {

//        Channel channel = chc.channel();

        ByteBuf inBuffer = (ByteBuf) msg;
        String received = inBuffer.toString(CharsetUtil.UTF_8);
        System.out.println("[Server received]: " + received);
        chc.writeAndFlush(Unpooled.copiedBuffer("Hello, How r u ?", CharsetUtil.UTF_8));

    }
    public void channelReadComplete(ChannelHandlerContext chc) throws Exception {
        chc.writeAndFlush(Unpooled.EMPTY_BUFFER)
                .addListener(ChannelFutureListener.CLOSE);
    }

    public void exceptionCaught(ChannelHandlerContext chc, Throwable cause) throws Exception {
        cause.printStackTrace();
        chc.close();
    }

}
