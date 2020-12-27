package com.nijad.database.controller;

import com.nijad.database.model.EmployeeDto;
import com.nijad.database.service.EmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/employee")
public class EmployeeController {
    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<EmployeeDto> findById(@PathVariable Long id){
        try{
            EmployeeDto employeeDto = employeeService.findById(id);
            return new ResponseEntity<>(employeeDto, HttpStatus.OK);
        }catch (RuntimeException e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }


    }
    @GetMapping
    public List<EmployeeDto> findAllEmployees(){
        return employeeService.findAllEmployees();
    }
    @PostMapping
    public ResponseEntity<Void> save(@RequestBody EmployeeDto employeeDto){
        employeeService.save(employeeDto);
        return  new ResponseEntity<>(HttpStatus.CREATED);
    }

}
