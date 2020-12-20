package com.nijad.database.service;

import com.nijad.database.dao.entity.Employee;
import com.nijad.database.model.EmployeeDto;

import java.util.Optional;

public interface EmployeeService {
    Optional<Employee> findById(Long id);
    Employee save(Employee employee);
    void updateEmployee(Long id, String firstname);
}
