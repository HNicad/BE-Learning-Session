package com.nijad.database.service;

import com.nijad.database.dao.entity.Employee;
import com.nijad.database.dao.repository.EmployeeRepository;
import com.nijad.database.mapper.EmployeeMapper;
import com.nijad.database.model.EmployeeDto;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    private final EmployeeRepository employeeRepository;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }


    @Override
    public Optional<Employee> findById(Long id) {
        return employeeRepository.findById(id);
    }

    @Override
    public Employee save(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public void updateEmployee(Long id, String firstname) {
        employeeRepository.updateEmployee(id,firstname);
    }
}
