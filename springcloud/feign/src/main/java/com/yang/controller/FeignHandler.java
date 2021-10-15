package com.yang.controller;

import com.yang.entity.Student;
import com.yang.fegin.FeignProviderClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

/**
 *  相对比与ribbon方式，feign的方式是面向接口编程，更为方便简洁而且好维护
 *      ribbon的controller实现方式，还是需要自己手动来写如何去调用，而feign只需要定义好一个FeignProviderClient接口，
 *      在接口上添加FeignClient注解，连接上所需要连接的服务(服务提供者provider)即可。controller层也是只需要调用接口中
 *      的功能就能进行相关业务的实现
 */

@RestController
@RequestMapping("/feign")
public class FeignHandler {

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
