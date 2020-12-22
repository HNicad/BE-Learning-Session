package com.nijad.hibernate.controller;

import com.nijad.hibernate.dao.entity.Salary;
import com.nijad.hibernate.error.EmployeeNotFound;
import com.nijad.hibernate.service.employee.EmployeeService;
import com.nijad.hibernate.service.salary.SalaryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SalaryController {
    private final SalaryService salaryService;
    private final EmployeeService employeeService;

    public SalaryController(SalaryService salaryService, EmployeeService employeeService) {
        this.salaryService = salaryService;
        this.employeeService = employeeService;
    }

    @PostMapping("/employee/{id}/salary")
    public ResponseEntity<Salary> saveSalary(@PathVariable Long id, @RequestBody Salary salary){
        return employeeService.findById(id)
                .map(employee -> {
                    salary.setEmployee(employee);
                    return new ResponseEntity<>(salaryService.save(salary), HttpStatus.CREATED);
                }).orElseThrow(() ->new EmployeeNotFound("Employee with id = " + id + " not found"));
    }
}
