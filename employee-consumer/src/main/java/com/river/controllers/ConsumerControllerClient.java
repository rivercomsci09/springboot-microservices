package com.river.controllers;

import com.river.model.Department;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;


@RestController
@RequestMapping("/")
public class ConsumerControllerClient {

    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping("/{id}")
    public Department getDepartment(@PathVariable final int id){
        Department department = new Department();
        department.setId(id);
        // get list of available employees
        List<Object> employees = restTemplate.getForObject("http://employee-producer/employees/", List.class);
        department.setEmployees(employees);
        return department;
    }
}
