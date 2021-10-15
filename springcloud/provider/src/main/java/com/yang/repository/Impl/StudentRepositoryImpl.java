package com.yang.repository.Impl;

import com.yang.entity.Student;
import com.yang.repository.StudentRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Repository     //这里需要加"Repository"注解，注册进IOC容器当中
public class StudentRepositoryImpl implements StudentRepository {

    private static Map<Integer,Student> map;

    static {
        map = new HashMap<>();
        map.put(1,new Student(1,"张三"));
        map.put(2,new Student(2,"李四"));
        map.put(3,new Student(3,"王五"));
        map.put(4,new Student(4,"太君"));
    }

    @Override
    public Collection<Student> findAll() {
        return map.values();
    }

    @Override
    public Student findById(Integer id) {
        return map.get(id);
    }

    @Override
    public void saveOrUpdate(Student student) {
        map.put(student.getId(),student);
    }

    @Override
    public void deleteById(Integer id) {
        map.remove(id);
    }
}
