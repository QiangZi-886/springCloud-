package com.yang.controller;

import com.yang.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.Collection;

@RestController
@RequestMapping("/rest")
public class RestHandler {

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/findAll")
    public Collection<User> findAll(){
        /**
         * 通过RestTemplate可以实现不同服务之间的调用，即restHandler没有对应的repository，和底层的实现方法，但是可以通过调用已有的userRepository
         * 来实现相关的业务，具体的调用方法就是通过getForObject方法，然后传入对应方法的url，和返回值的类型即可
         */

        return restTemplate.getForObject("http://localhost:8080/user/findAll",Collection.class);
    }

    @GetMapping("findById/{id}")
    public User findById(@PathVariable("id") Integer id){
        //这里需要注意带参数的方法的书写格式，形参列表里跟原先一样使用@PathVarible接收，
        //然后在下面使用restTemplate调用的时候，注意参数是三个，然后url中也要在后面追加对于的数据
        //还有一点，这里的User数据其实是从userHandler中使用json格式传送过来的，然后它需要实体类中有无参构造，否则就会报错
        return restTemplate.getForObject("http://localhost:8080/user/findById/{id}",User.class,id);
    }

    @PostMapping("/save")
    public void save(@RequestBody User user){
        //这里的方法是需要三个参数的，分别是url、请求的Object类、还有一个返回值类型，但是userHandler中的save方法没有返回值，
        // 所以这里最后的Collection.class是空的
        restTemplate.postForObject("http://localhost:8080/user/save",user,Collection.class);
    }

    @PutMapping("/update")
    public void update(@RequestBody User user){
        restTemplate.put("http://localhost:8080/user/update",user);
    }

    @DeleteMapping("/deleteById/{id}")
    public void deleteById(@PathVariable("id") Integer id){
        restTemplate.delete("http://localhost:8080/user/deleteById/{id}",id);
    }

}
