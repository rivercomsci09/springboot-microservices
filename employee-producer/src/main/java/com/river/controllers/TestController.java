package com.river.controllers;

import com.river.model.Employee;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/")
public class TestController {

    @RequestMapping(value = "/employees", method = RequestMethod.GET)
    public List<Employee> getEmployees(){
        List<Employee> employees = Arrays.asList(
                new Employee("1","emp1","manager",3000),
                new Employee("2","emp2","manager",2000),
                new Employee("3","emp3","manager",5000)
        );
        return employees;
    }
}
