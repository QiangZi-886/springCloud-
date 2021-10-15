package com.yang.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/native")
public class NativeConfigHandler {

    @Value("${server.port}")    //拿到nativeconfigserver中配置文件的端口号
    private String port;

    @Value("${foo}")        //同样拿到foo的版本信息
    private String foo;

    @GetMapping("/index")
    public String index(){
        return this.port+"---"+this.foo;
    }

}
