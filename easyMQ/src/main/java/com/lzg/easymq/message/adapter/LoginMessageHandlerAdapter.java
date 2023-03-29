package com.lzg.easymq.message.adapter;

import com.lzg.easymq.message.handler.LoginMessageHandler;

public class LoginMessageHandlerAdapter extends MessageHandlerAdapter {

    public LoginMessageHandlerAdapter() {
        this.messageHandler = new LoginMessageHandler();
    }

    @Override
    public boolean isSupport(Object handler) {
        return false;
    }
}
