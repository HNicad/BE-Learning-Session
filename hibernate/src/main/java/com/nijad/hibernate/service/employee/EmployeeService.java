package com.nijad.hibernate.service.employee;

import com.nijad.hibernate.dao.entity.Employee;

import java.util.List;
import java.util.Optional;

public interface EmployeeService {
    List<Employee> findAll();
    Employee save(Employee employee);
    void deleteById(Long id);
    Optional<Employee> findById(Long id);
}
