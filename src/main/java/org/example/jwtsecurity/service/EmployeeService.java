package org.example.jwtsecurity.service;

import org.example.jwtsecurity.model.Employee;
import org.example.jwtsecurity.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class EmployeeService {

    @Autowired
    private EmployeeRepository repository;

    public List<Employee> findAll() {
        return repository.findAll();
    }

    public List<Employee> findByName(String name) {
        return repository.findEmployeesByNameLike(name);
    }


    public Employee findById(Integer id) {
        return repository.findById(id)
                .orElse(null);
    }

    public Page<Employee> findPage(int i) {
        Pageable page= PageRequest.of(i - 1, 10);
        return repository.findAll(page);
    }

    public void save(Employee employee) {
        repository.save(employee);
    }
}
