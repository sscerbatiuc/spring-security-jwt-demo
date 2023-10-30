package org.example.jwtsecurity.repository;

import org.example.jwtsecurity.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

    List<Employee> findEmployeesByNameLike(String name);
}
