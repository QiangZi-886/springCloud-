package com.yang;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * 通过RestTemplate就可以实现不同微服务之间的调用
 */
@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        ConfigurableApplicationContext applicationContext = SpringApplication.run(Application.class, args);
        System.out.println(applicationContext.getBean(RestTemplate.class));
    }

/*    @Bean
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }*/
}
