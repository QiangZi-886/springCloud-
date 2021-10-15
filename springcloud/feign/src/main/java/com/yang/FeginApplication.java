package com.yang;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients     //加了这个注解fegin才会生效
public class FeginApplication {
    public static void main(String[] args) {
        SpringApplication.run(FeginApplication.class,args);
    }
}
