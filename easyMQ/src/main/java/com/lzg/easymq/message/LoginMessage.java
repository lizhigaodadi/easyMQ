package com.lzg.easymq.message;

public class LoginMessage {   // 只记录消息的长度   // 每一个字段前面都有一个记录来存储字段长度
    public String username;
    public String password;
    public String msgId;   // 这个通常作为结尾出现
}
