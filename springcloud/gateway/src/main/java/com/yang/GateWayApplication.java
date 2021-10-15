package com.yang;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@EnableZuulProxy    //网关的服务
@EnableAutoConfiguration       //这里也可以直接使用@SpringBootApplication,但是它实际用的就是这个@EnableAutoConfiguration，所以不需要那么麻烦
public class GateWayApplication {
    public static void main(String[] args) {
        SpringApplication.run(GateWayApplication.class,args);

        /**
         * 并且，zuul除了处理路由映射之外，还自带负载均衡的功能。
         *
         *      比如，现在consumer有两个(现实有很多很多个，这里为了方便理解)，分别获取consumer消费者的端口号(这里给出两个端口号用作区分)，
         *      然后用户访问consumer，怎么实现它的负载均衡？(假如有很多个消费者，每个都在访问这里的eureka，那么如何分配使得系统稳定？)
         *
         *      首先、你可以通过它原本的端口(两个)进行各自的访问，但是是两个完全不同的URL
         *
         *    **这里可以直接通过gateway进行访问，zuul会自动进行负载均衡算法进行不同的分配。(两个client就会分配成交替访问)
         *
         */
    }
}
