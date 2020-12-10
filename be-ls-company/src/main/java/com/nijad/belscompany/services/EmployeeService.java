package com.nijad.belscompany.services;

import com.nijad.belscompany.models.Employee;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeService {
    private final List<Employee> employees;

    public EmployeeService() {
        this.employees = new ArrayList<>();
    }

    public List<Employee> getEmployees() {
        return employees;
    }
    public Employee getEmployeeById(Long id){
        return employees.stream().filter( e -> e.getId().equals(id) ).findAny().orElse(null);
    }
    public Employee createEmployee(Employee employee){
        employees.add(employee);
        return employee;
    }
    public Employee updateEmployeeById(Long id, Employee employee){
        for(int i = 0; i < employees.size(); i++){
            if(employees.get(i).getId().equals(id)){
                employees.set(i,employee);
                return employees.get(i);
            }
        }
        return null;
    }
    public Long deleteEmployeeById(Long id){
        for(int i = 0; i < employees.size(); i++){
            if(employees.get(i).getId().equals(id)){
                employees.remove(i);
                return id;
            }
        }
        return null;
    }
}
