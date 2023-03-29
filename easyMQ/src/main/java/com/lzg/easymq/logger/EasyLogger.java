package com.lzg.easymq.logger;

import java.io.FileNotFoundException;

public class EasyLogger {
    private static MyLogger logger;    // 聚合到这个类中
    public static void log(LogType logType,String message) {   // 全局的一个日志处理
        logger.show(logType,message);
        logger.write(logType,message);
    }

    public static void init(MyLogger initLogger) {    //初始化日志配置
        logger = initLogger;   // Logger 作为组件加入到这个类中
        try {
            logger.initLog();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void shutdown() {
        logger.gracefullyClose();
    }

}
