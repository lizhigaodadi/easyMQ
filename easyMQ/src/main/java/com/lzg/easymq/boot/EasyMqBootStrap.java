package com.lzg.easymq.boot;

import com.lzg.easymq.baseconfig.BaseConfig;
import lombok.extern.slf4j.Slf4j;

public class EasyMqBootStrap {
    public static void init() {    // 初始化类，只会执行一次
        if (!BaseConfig.IS_INIT.compareAndSet(false,true)) {
            BaseConfig.INIT = true;
            return;   // 该方法只会执行一次
        }

        // TODO 开始进行mq的初始化工作

    }
}
