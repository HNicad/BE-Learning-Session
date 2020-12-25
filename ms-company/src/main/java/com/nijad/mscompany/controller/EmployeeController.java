package com.nijad.mscompany.controller;


import com.nijad.mscompany.model.EmployeeDto;
import com.nijad.mscompany.service.EmployeeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/employee")
@Api("Employee Controller")
public class EmployeeController {
    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @ApiOperation("Gets all the employees")
    @GetMapping
    public List<EmployeeDto> employeeDtoList(){
        return employeeService.getAllEmployees();
    }
    @ApiOperation("Gets the employee by id")
    @GetMapping("/{id}")
    public EmployeeDto employeeDto(@PathVariable Long id){
        return employeeService.getEmployeeById(id);
    }

}
