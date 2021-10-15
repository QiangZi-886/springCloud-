package com.yang.controller;

import com.yang.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.Collection;

@RestController
@RequestMapping("/consumer")
public class StudentHandler {

    @Autowired
    private RestTemplate restTemplate;

    //这里如果想拿到配置文件中的数据，只需要使用@Value注解，然后在里面使用spring的书写格式就可以拿到了(注意：这里使用的注解是由springframework。bean提供的)
    @Value("${server.port}")
    private String port;


    @GetMapping("/index")
    public String index(){
        return port;
    }


    @GetMapping("/findAll")
    public Collection<Student> findAll(){
        return restTemplate.getForObject("http://localhost:8010/provider/findAll",Collection.class);
    }

    @GetMapping("/findById/{id}")
    public Student findById(@PathVariable("id") Integer id){
        return restTemplate.getForObject("http://localhost:8010/provider/findById/{id}",Student.class,id);
    }

    @PostMapping("/save")
    public void save(@RequestBody Student student){
        restTemplate.postForObject("http://localhost:8010/provider/save",student,Student.class);
    }

    @PutMapping("/update")
    public void update(@RequestBody Student student){
        restTemplate.put("http://localhost:8010/provider/update",student);
    }

    @DeleteMapping("/deleteById/{id}")
    public void updateById(@PathVariable("id") Integer id){
        restTemplate.delete("http://localhost:8010/provider/deleteById/{id}",id);
    }
}
