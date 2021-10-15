package com.yang;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class EurekaServerApplication {
    //书写注册中心的启动类
    public static void main(String[] args) {
        SpringApplication.run(EurekaServerApplication.class,args);
    }
}
