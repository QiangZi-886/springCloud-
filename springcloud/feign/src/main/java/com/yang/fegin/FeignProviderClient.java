package com.yang.fegin;

import com.yang.entity.Student;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@FeignClient(value = "provider")//直接使用这个注解就是声明使用Feign，然后其中的value属性值填入注册中心中其他服务的名字。填写对应的名字就是连接到对应的服务
public interface FeignProviderClient {

    @GetMapping("/provider/findAll")    //这里的GetMapping其中的路径只需要填写服务提供者handler中的url即可，因为@FeignClient已经连接上了该服务
    public Collection<Student> findAll();

    @GetMapping("/provider/findById/{id}")
    public Student findById(@PathVariable("id") Integer id);

    @PostMapping("/provider/save")
    public void save(@RequestBody Student student);

    @PutMapping("/provider/update")
    public void update(@RequestBody Student student);

    @DeleteMapping("/provider/deleteById/{id}")
    public void deleteById(@PathVariable("id") Integer id);
}
