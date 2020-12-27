package com.nijad.database.service;

import com.nijad.database.dao.entity.Employee;
import com.nijad.database.dao.repository.EmployeeRepository;
import com.nijad.database.mapper.EmployeeMapper;
import com.nijad.database.model.EmployeeDto;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    private final EmployeeRepository employeeRepository;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }


    @Override
    public EmployeeDto findById(Long id) {
        Employee employee = employeeRepository.findById(id).orElseThrow(() -> new RuntimeException("Not Found"));
        return EmployeeMapper.entityToDto(employee);
    }

    @Override
    public void save(EmployeeDto employeeDto) {
        employeeRepository.save(EmployeeMapper.dtoToEntity(employeeDto));
    }

    @Override
    public List<EmployeeDto> findAllEmployees() {
        return EmployeeMapper.entitiesToDtos(employeeRepository.findAll());
    }


}
