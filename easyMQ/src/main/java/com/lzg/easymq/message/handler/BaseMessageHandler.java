package com.lzg.easymq.message.handler;

public abstract class BaseMessageHandler {
    protected int messageType;
    public abstract String encode(String message);
    public abstract String decode(String message);
}
