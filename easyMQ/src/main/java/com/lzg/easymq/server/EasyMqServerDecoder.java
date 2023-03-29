package com.lzg.easymq.server;

import com.lzg.easymq.message.MessageProtocol;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;

import java.util.List;

public class EasyMqServerDecoder extends ByteToMessageDecoder {
    @Override
    protected void decode(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf, List<Object> list) throws Exception {
        MessageProtocol messageProtocol = new MessageProtocol();
        // TODO 消息解析
        if (byteBuf.readableBytes() >= 4) {
            messageProtocol.msgLength = byteBuf.readInt();
            byte[] content = new byte[messageProtocol.msgLength];
            byteBuf.readBytes(content);

            list.add(messageProtocol);   // 传递给小一个解析器
        }
    }
}
