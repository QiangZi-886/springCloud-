package com.yang.controller;

import com.yang.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Collection;

/**
 *  ribbon处理负载均衡
 *      ribbon也是 Netflix 发布的负载均衡器，只不过spring再一次封装了ribbon，然后在spring中就可以直接使用了、
 *      关于ribbon的使用，同样也是通过获取端口号来进行测试，这里采用的是通过RestTemplate来调用之前做过端口测试的consumer
 *
 *      ribbon相对于zuul，它的优点在于，原先的zuul，网关虽然自带负载均衡，但是它不能再添加逻辑处理，只是提供了一个简化的方式
 *      但是ribbon可以添加逻辑处理了之后再去通过restTemplate进行访问。
 */

@RestController
@RequestMapping("/ribbon")
public class RibbonHandler {

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/findAll")
    public Collection<Student> findAll(){

        //这里可以再添加额外的逻辑处理

        return restTemplate.getForObject("http://provider/provider/findAll",Collection.class);
    }

    @GetMapping("/index")
    public String index(){
        return restTemplate.getForObject("http://consumer/consumer/index",String.class);
    }
}
