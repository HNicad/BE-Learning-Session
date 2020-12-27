package com.nijad.database.util

import com.nijad.database.dao.entity.Employee
import com.nijad.database.model.EmployeeDto

class EmployeeGenerator {
    static Employee generateEmployee(){
        return RandomUtil.random.nextObject(Employee.class)
    }
    static EmployeeDto generateEmployeeDto(){
        return RandomUtil.random.nextObject(EmployeeDto.class)
    }
    static List<Employee> generateEmployees(int size){
        List<Employee> employees = new ArrayList<>();
        for(int i = 0; i < size; i++){
            employees.add(generateEmployee());
        }
        return employees;
    }
    static List<EmployeeDto> generateEmployeeDtos(int size){
        List<EmployeeDto> employeeDtos = new ArrayList<>();
        for(int i = 0; i < size; i++){
            employeeDtos.add(generateEmployeeDto());
        }
        return employeeDtos;
    }

}
