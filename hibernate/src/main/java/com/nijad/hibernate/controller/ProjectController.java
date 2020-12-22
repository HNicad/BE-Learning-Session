package com.nijad.hibernate.controller;


import com.nijad.hibernate.dao.entity.Project;
import com.nijad.hibernate.error.EmployeeNotFound;
import com.nijad.hibernate.service.employee.EmployeeService;
import com.nijad.hibernate.service.project.ProjectService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProjectController {
    private final ProjectService projectService;
    private final EmployeeService employeeService;

    public ProjectController(ProjectService projectService, EmployeeService employeeService) {
        this.projectService = projectService;
        this.employeeService = employeeService;
    }

    @GetMapping("/employee/{id}/project")
    public ResponseEntity<List<Project>> getProjectByEmployeeId(@PathVariable Long id){
        return new ResponseEntity<>(projectService.findByEmployeeId(id), HttpStatus.OK);
    }

    @PostMapping("/employee/{id}/project")
    public ResponseEntity<Project> saveProject(@PathVariable Long id, @RequestBody Project project){
        return employeeService.findById(id)
                .map(employee -> {
                    project.setEmployee(employee);
                    return new ResponseEntity<>(projectService.save(project),HttpStatus.CREATED);
                }).orElseThrow(() -> new EmployeeNotFound("Employee with id = " + id + " not found"));
    }
}
