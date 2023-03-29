package com.lzg.easymq.logger;

import sun.rmi.runtime.Log;

import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.OutputStream;

public abstract class MyLogger {
    public InputStream is;
    public OutputStream os;

    public abstract void initLog() throws FileNotFoundException;
    public abstract void write(LogType type, String message);
    public abstract void show(LogType type, String message);
    public abstract void gracefullyClose();
}
