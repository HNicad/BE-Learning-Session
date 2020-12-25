package com.nijad.mscompany.service;

import com.nijad.mscompany.model.EmployeeDto;

import java.util.List;

public interface EmployeeService {
    List<EmployeeDto> getAllEmployees();
    EmployeeDto getEmployeeById(Long id);
}
