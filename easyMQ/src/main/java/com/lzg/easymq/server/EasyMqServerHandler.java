package com.lzg.easymq.server;

import com.lzg.easymq.message.MessageProtocol;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.channel.SimpleChannelInboundHandler;

public class EasyMqServerHandler extends SimpleChannelInboundHandler<MessageProtocol> {

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        super.exceptionCaught(ctx, cause);
    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        super.channelActive(ctx);
    }

    @Override
    protected void channelRead0(ChannelHandlerContext channelHandlerContext, MessageProtocol messageProtocol) throws Exception {
        //开始进行消息的解析
        byte[] content = messageProtocol.contents;
        long msgLength = messageProtocol.msgLength;

    }
}
