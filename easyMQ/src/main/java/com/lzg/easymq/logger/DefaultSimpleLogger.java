package com.lzg.easymq.logger;

import com.lzg.easymq.baseconfig.BaseConfig;
import lombok.extern.slf4j.Slf4j;

import java.io.*;
import java.nio.charset.StandardCharsets;


@Slf4j
public class DefaultSimpleLogger extends MyLogger {
    @Override
    public void initLog() throws FileNotFoundException {
        //读取文件
        this.os = new FileOutputStream(BaseConfig.LOG_FILE);
        this.os = new BufferedOutputStream(this.os,1024);   // 写入的缓冲流

    }

    public static String match(String message, LogType logType) {
        if (logType == LogType.ERROR) {  // Error
            return "[error]: " + message + "\n";
        } else if (logType == LogType.WARN) {   // Warning
            return "[warning]: " + message + "\n";
        } else {  // log
            return "[log]: " + message + "\n";
        }
    }

    @Override
    public void write(LogType type, String message) {

        String realMsg = match(message, type);

        try {
            this.os.write(realMsg.getBytes(StandardCharsets.UTF_8));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void show(LogType type, String message) {
        String realMsg = match(message, type);
        System.out.print(realMsg.getBytes(StandardCharsets.UTF_8));

    }

    @Override
    public void gracefullyClose()  {    // 最后的收尾操作
        try {
            this.os.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
