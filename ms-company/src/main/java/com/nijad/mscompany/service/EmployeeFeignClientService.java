package com.nijad.mscompany.service;

import com.nijad.mscompany.client.EmployeeFeignClient;
import com.nijad.mscompany.model.EmployeeDto;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.List;
@Profile("prod")
@Service
public class EmployeeFeignClientService implements EmployeeService {
    private final EmployeeFeignClient employeeFeignClient;

    public EmployeeFeignClientService(EmployeeFeignClient employeeFeignClient) {
        this.employeeFeignClient = employeeFeignClient;
    }

    @Override
    public List<EmployeeDto> getAllEmployees() {
        return employeeFeignClient.getAllEmployees();
    }

    @Override
    public EmployeeDto getEmployeeById(Long id) {
        return employeeFeignClient.getEmployeeById(id);
    }
}
