package com.lzg.easymq.message.handler;

import com.lzg.easymq.message.MessageType;
import com.lzg.easymq.message.handler.BaseMessageHandler;

public class LoginMessageHandler extends BaseMessageHandler {    // 作为客户端连接发送的消息处理器

    public LoginMessageHandler() {
        this.messageType = MessageType.LOGIN;   //　设置消息类型
    }

    @Override
    public String encode(String message) {
        return message;
    }

    @Override
    public String decode(String message) {
        return message;
    }
}
