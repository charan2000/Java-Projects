
import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

import java.util.ArrayList;
import java.util.List;

public class ChatServerHandler extends SimpleChannelInboundHandler<String> {
    // List of connected client channels.

    List<Channel> channelList = new ArrayList<>();

    //    * Whenever client connects to server through channel, add his channel to the
//	 * list of channels.
    public void channelActive(ChannelHandlerContext chc) {
        System.out.println("Client Connected: "+chc.toString());
        channelList.add(chc.channel());
    }

    @Override
    protected void channelRead0(ChannelHandlerContext channelHandlerContext, String s) throws Exception {
        for(Channel ch : channelList) {
            System.out.println("Client Sent -> : "+s);
            ch.writeAndFlush("->"+s+"\n");
        }
    }

    public void exceptionCaught(ChannelHandlerContext chc, Throwable cause) {
        System.out.println("Closing Connection for :"+chc.toString());
        chc.close();
    }
}
