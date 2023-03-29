package com.lzg.easymq.baseconfig;

import java.util.concurrent.atomic.AtomicBoolean;

public class BaseConfig {    // 基础的配置类
    public static boolean SHOW_LOG = false;   //默认不开启日志功能
    public static boolean IS_PERSISTENT = false;   // 默认不开启持久化
    public static int MAX_RESEND = 5;     //最大重发次数
    public static String LOCAL_HOST = "localhost";
    public static int PORT = 6666;
    public static String LOG_FILE = "log.txt";
    public static AtomicBoolean IS_INIT = new AtomicBoolean(false);    //原子操作类
    public static boolean INIT = false; // 防止过多的原子操作影响效率

}
