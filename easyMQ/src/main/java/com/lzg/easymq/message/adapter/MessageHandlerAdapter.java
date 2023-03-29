package com.lzg.easymq.message.adapter;

import com.lzg.easymq.message.handler.BaseMessageHandler;

public abstract class MessageHandlerAdapter {
    public BaseMessageHandler messageHandler;    // 聚合一个消息处理器
    public abstract boolean isSupport(Object handler);
}
