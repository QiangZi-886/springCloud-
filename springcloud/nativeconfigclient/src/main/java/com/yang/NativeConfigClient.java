package com.yang;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 *  springCloud全局配置的客户端
 *      它是由全局配置服务来进行它的配置文件的管理的，在这个client客户端的resources文件夹中的配置文件中只有它对应的全局配置server的uri，和
 *      它需要在nativeconfigserver中读取的配置文件的名称。
 *
 *      注意： 这里的是bootstrap.yml配置文件，且全局服务的端口是8762，所以在原来的注册中心中是看不到这个nativeconfigclient客户端的
 */

@SpringBootApplication
public class NativeConfigClient {
    public static void main(String[] args) {
        SpringApplication.run(NativeConfigClient.class,args);
    }
}
