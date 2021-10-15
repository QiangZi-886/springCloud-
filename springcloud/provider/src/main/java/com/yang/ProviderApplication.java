package com.yang;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ProviderApplication {

    /**
     *  这里的服务提供者如果想要注册进注册中心，需要注意各个启动类的启动顺序
     *      肯定需要先将注册中心启动起来，然后才能将服务提供者注册进去
     * @param args
     */

    public static void main(String[] args) {
        SpringApplication.run(ProviderApplication.class,args);
    }
}
