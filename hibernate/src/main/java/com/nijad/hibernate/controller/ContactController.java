package com.nijad.hibernate.controller;

import com.nijad.hibernate.dao.entity.Contact;
import com.nijad.hibernate.error.EmployeeNotFound;
import com.nijad.hibernate.service.contact.ContactService;
import com.nijad.hibernate.service.employee.EmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ContactController {
    private final ContactService contactService;
    private final EmployeeService employeeService;

    public ContactController(ContactService contactService, EmployeeService employeeService) {
        this.contactService = contactService;
        this.employeeService = employeeService;
    }

    @GetMapping("/employee/{id}/contact")
    public ResponseEntity<List<Contact>> getContactByEmployeeId(@PathVariable Long id){
        return new ResponseEntity<>(contactService.findByEmployeeId(id),HttpStatus.OK);
    }

    @PostMapping("/employee/{id}/contact")
    public ResponseEntity<Contact> saveContact(@PathVariable Long id, @RequestBody Contact contact){
        return employeeService.findById(id)
                .map(employee -> {
                    contact.setEmployee(employee);
                    return new ResponseEntity<>(contactService.save(contact), HttpStatus.CREATED);
                }).orElseThrow(() -> new EmployeeNotFound("Employee with id = " + id + " not found"));
    }

}
