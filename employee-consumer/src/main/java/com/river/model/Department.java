package com.river.model;

import java.util.List;

public class Department {

    private int id;
    private List<Object> employees;

    public Department() {
    }

    public Department(int id, List<Object> employees) {
        this.id = id;
        this.employees = employees;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Object> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Object> employees) {
        this.employees = employees;
    }
}
