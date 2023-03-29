package com.lzg.easymq.client;

import com.lzg.easymq.baseconfig.BaseConfig;
import com.lzg.easymq.server.EasyMqServerChannelInitializer;
import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;

public class EasyMqClient  {
    public void init() {
        NioEventLoopGroup group = new NioEventLoopGroup();
        try {
            Bootstrap bootStrap = new Bootstrap();

            bootStrap.group(group)
                    .channel(NioSocketChannel.class)
                    .handler(new EasyMqClientChannelInitializer());

            System.out.println("client is ready");

            ChannelFuture cf = bootStrap.bind(BaseConfig.LOCAL_HOST, BaseConfig.PORT).sync();
        } catch (InterruptedException e) {

            e.printStackTrace();
        } finally {

            group.shutdownGracefully();
        }

    }
}
