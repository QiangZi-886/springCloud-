package com.yang;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

/**
 * 这里是配置服务全局文件的server，还需要一个client客户端来调用
 *      全局配置服务中会给调用它的客户端提供对应的端口号，和对应的一些配置
 */

@SpringBootApplication
@EnableConfigServer
public class NativeConfigServer {
    public static void main(String[] args) {
        SpringApplication.run(NativeConfigServer.class,args);
    }
}
