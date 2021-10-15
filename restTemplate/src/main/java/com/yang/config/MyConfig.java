package com.yang.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 *
 *  这是关于RestTemplate的一个配置类，也可以直接写在启动类Application中，因为Application启动类上面的@SprngBootApplication注解
 *  就包括了@Configuration注解
 *      这里的@Configuration注解就相当于是一个xml文件，@Bean注解就相当于是xml文件中的一个<bean></bean>标签
 *      这个配置类就会将RestTemplate注入IOC容器中由Spring管理
 */


@Configuration
public class MyConfig {

    @Bean
    public RestTemplate restTemplate(){     //注意 这里在IOC容器中的bean名称就是方法名
        return new RestTemplate();
    }
}
