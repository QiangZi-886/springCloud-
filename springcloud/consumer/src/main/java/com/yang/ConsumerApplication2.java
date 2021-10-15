package com.yang;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 *  这里进行的是zuul的负载均衡的功能，测试的对象是consumer这个服务的端口号(使用的分别是8020、8021，原先使用的8020)，现已改回
 *
 *      记录：因为读取的都是同一份yml文件，那么怎么实现拿到的是不同的端口号呢？
 *          首先注册进的是8020这个端口，在服务注册进中心的时候，再复制一份ConsumerApplication2，然后更改yml文件的端口号为8021
 *          然后再启动ConsumerApplication2，这样一来，原先的服务也在注册中心当中，而且又额外增加了一个端口号为8021的消费者服务
 *          最后就可以进行测试了
 */

@SpringBootApplication
public class ConsumerApplication2 {
    public static void main(String[] args) {
        SpringApplication.run(ConsumerApplication2.class,args);
    }

    @Bean
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }
}
