package com.nijad.database.controller;

import com.nijad.database.dao.entity.Employee;
import com.nijad.database.mapper.EmployeeMapper;
import com.nijad.database.model.EmployeeDto;
import com.nijad.database.service.EmployeeService;
import org.springframework.web.bind.annotation.*;

@RestController
public class EmployeeController {
    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping(value = "/employee/{id}")
    public EmployeeDto findById(@PathVariable Long id){
        Employee employee = employeeService.findById(id).orElse(null);
        EmployeeDto employeeDto = EmployeeMapper.INSTANCE.employeeToEmployeeDto(employee);
        return employeeDto;
    }
    @PostMapping(value = "/employee")
    public EmployeeDto save(@RequestBody EmployeeDto employeeDto){
        Employee employee = EmployeeMapper.INSTANCE.employeeDtoToEmployee(employeeDto);
        employeeDto = EmployeeMapper.INSTANCE.employeeToEmployeeDto(employeeService.save(employee));
        return employeeDto;
    }
    @PostMapping(value = "/update/{id}")
    public int update(@PathVariable Long id, @RequestBody EmployeeDto employeeDto){
        String firstname = employeeDto.getFirstname();
        employeeService.updateEmployee(id,firstname);
        return 1;
    }

}
