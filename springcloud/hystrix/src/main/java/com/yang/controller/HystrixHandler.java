package com.yang.controller;

import com.yang.entity.Student;
import com.yang.feign.FeignProviderClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

/**
 *  在浏览器进行测试的时候，不使用数据监控可视化工具之前访问的URL是：http://localhost:8060/actuator/hystrix.stream
 *      然后在这歌URL访问的界面中，会不停的发送ping请求，在你不进行任何操作的时候，ping的就是空的信息，当你通过hystrix的handler进行一些数
 *      据操作的时候，hystrix.stream就会ping出你所访问的所有信息: 调用的接口、服务的名称等
 *
 *  通过可视化界面进行数据监控的时候访问的URL是: http://localhost:8060/hystrix
 *      直接访问这个URL，就会进入到一个可视化的一个界面，在界面中直接输入刚才带有节点流的URL，也就是http://localhost:8060/actuator/hystrix.stream
 *      然后点击Monitor Stream，就会进入到一个实时监控数据的界面，再进行数据访问的时候，这个可视化的界面就会友好的展示出所有的信息
 */

@RestController
@RequestMapping("/hystrix")
public class HystrixHandler {

    @Autowired
    private FeignProviderClient feignProviderClient;

    @GetMapping("/findAll")
    public Collection<Student> findAll(){
        return feignProviderClient.findAll();
    }

    @GetMapping("/findById/{id}")
    public Student findById(@PathVariable("id") Integer id){
        return feignProviderClient.findById(id);
    }

    @PostMapping("/save")
    public void save(@RequestBody Student student){
        feignProviderClient.save(student);
    }

    @PutMapping("/update")
    public void update(@RequestBody Student student){
        feignProviderClient.update(student);
    }

    @DeleteMapping("/deleteById/{id}")
    public void updateById(@PathVariable("id") Integer id){
        feignProviderClient.deleteById(id);
    }
}
