package com.river.controllers;

import com.river.model.Department;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
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

    @RequestMapping(value = "/departments", method = RequestMethod.GET)
    public List<Department> getDepartments(){
        // get list of available employees
        List<Object> employees = restTemplate.getForObject("http://employee-producer/employees/", List.class);
        List<Department> departments = Arrays.asList(
                new Department(1,employees),
                new Department(2,employees),
                new Department(3,employees)
        );
        return departments;
    }
}
