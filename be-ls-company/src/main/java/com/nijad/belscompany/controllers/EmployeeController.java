package com.nijad.belscompany.controllers;

import com.nijad.belscompany.models.Employee;
import com.nijad.belscompany.services.EmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }
    @GetMapping
    public List<Employee> getEmployees(){
        return employeeService.getEmployees();
    }
    @GetMapping(value = "/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable Long id){
        Employee employee = employeeService.getEmployeeById(id);
        if(employee == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(employee,HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<Employee> createEmployee(@RequestBody Employee employee){
        return new ResponseEntity<>(employeeService.createEmployee(employee),HttpStatus.CREATED);
    }
    @PutMapping(value = "/{id}")
    public ResponseEntity<Employee> updateEmployeeById(@PathVariable Long id, @RequestBody Employee employee){
        if(employeeService.updateEmployeeById(id,employee) == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(employeeService.updateEmployeeById(id,employee),HttpStatus.OK);
    }
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<String> deleteEmployeeById(@PathVariable Long id){
        if(employeeService.deleteEmployeeById(id) == null){
            return new ResponseEntity<>("No such Employee", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<> ("Deleted Successfully", HttpStatus.OK);
    }

}
