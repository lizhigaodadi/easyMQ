package com.lzg.easymq.server;

import com.lzg.easymq.baseconfig.BaseConfig;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;

public class EasyMQInitServer {

    public void initEasyMqServer() {    // 初始化服务器线程
        NioEventLoopGroup bossGroup = new NioEventLoopGroup();   // 接受请求的线程
        NioEventLoopGroup workerGroup = new NioEventLoopGroup();   // 工作线程


        ServerBootstrap serverBootstrap = new ServerBootstrap();
        serverBootstrap.group(bossGroup,workerGroup)
                .channel(NioServerSocketChannel.class)
                .childHandler(new EasyMqServerChannelInitializer());

        try {
            ChannelFuture cf = serverBootstrap.bind(BaseConfig.PORT).sync();
            cf.channel().closeFuture().sync();
            System.out.println("Server is ready to accept connections");

        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            //最后的关闭工作
            bossGroup.shutdownGracefully();
            workerGroup.shutdownGracefully();
        }


    }
}
