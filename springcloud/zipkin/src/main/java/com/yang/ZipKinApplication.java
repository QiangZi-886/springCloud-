package com.yang;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import zipkin.server.internal.EnableZipkinServer;

/**
 *  在这里记录一个我赞水没有解决的错误，服务追踪组件zipkin server服务启动报错，问题没有搜到，暂时没有解决
 *      Error creating bean with name 'embeddedServletContainerFactory'
 *
 *    服务追踪的主要使用思路：
 *      首先是需要一个提供server的服务，即ZipKinServer，然后还需要一个客户端Client用来调用这个服务，哲个服务中导入的有web和zipkin的ui界面依赖
 *      然后客户端只需要调用即可，然后在客户端的逻辑处理controller中定义好一个用来做测试的方法(这里就只是取出yml中的port端口号即可)
 *
 *    大体思路是这样，但是启动的时候报错，暂时未得到解决。。。。
 */


@SpringBootApplication
@EnableZipkinServer
public class ZipKinApplication {
    public static void main(String[] args) {
        SpringApplication.run(ZipKinApplication.class,args);
    }
}
