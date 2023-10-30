package org.example.jwtsecurity.controller;

import org.example.jwtsecurity.model.Employee;
import org.example.jwtsecurity.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping
    public List<Employee> getAll() {
        return employeeService.findAll();
    }


    @GetMapping("/name/{name}")
    public List<Employee> getAll(@PathVariable String name) {
        return employeeService.findByName(name);
    }

    @GetMapping("/{id}")
    public Employee getById(@PathVariable("id") Integer id) {
        return employeeService.findById(id);
    }
}
