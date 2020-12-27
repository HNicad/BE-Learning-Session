package com.nijad.database.service;

import com.nijad.database.dao.entity.Employee;
import com.nijad.database.model.EmployeeDto;

import java.util.List;
import java.util.Optional;

public interface EmployeeService {
    EmployeeDto findById(Long id);
    void save(EmployeeDto employeeDto);
    List<EmployeeDto> findAllEmployees();
}
