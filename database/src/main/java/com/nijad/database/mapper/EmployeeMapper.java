package com.nijad.database.mapper;


import com.nijad.database.dao.entity.Employee;
import com.nijad.database.model.EmployeeDto;

import java.util.List;
import java.util.stream.Collectors;

public class EmployeeMapper{
    public static Employee dtoToEntity(EmployeeDto employeeDto){
        Employee employee = new Employee();
        employee.setId(employeeDto.getId());
        employee.setFirstname(employeeDto.getFirstname());
        employee.setLastname(employeeDto.getLastname());
        employee.setGender(employeeDto.getGender());
        employee.setDepartment(employeeDto.getDepartment());
        employee.setSalary(employeeDto.getSalary());
        return employee;
    }
    public static EmployeeDto entityToDto(Employee employee){
        return EmployeeDto.builder()
                .id(employee.getId())
                .firstname(employee.getFirstname())
                .lastname(employee.getLastname())
                .salary(employee.getSalary())
                .gender(employee.getGender())
                .department(employee.getDepartment())
                .build();
    }
    public static List<Employee>dtosToEntities(List<EmployeeDto> employeeDtos){
        return employeeDtos
                .stream()
                .map(EmployeeMapper::dtoToEntity)
                .collect(Collectors.toList());
    }
    public static List<EmployeeDto> entitiesToDtos(List<Employee> employees){
        return employees
                .stream()
                .map(EmployeeMapper::entityToDto)
                .collect(Collectors.toList());
    }

}
