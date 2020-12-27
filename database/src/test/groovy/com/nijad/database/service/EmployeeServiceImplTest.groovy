package com.nijad.database.service

import com.nijad.database.dao.entity.Employee
import com.nijad.database.dao.enums.Gender
import com.nijad.database.dao.repository.EmployeeRepository
import com.nijad.database.mapper.EmployeeMapper
import com.nijad.database.model.EmployeeDto
import com.nijad.database.util.EmployeeGenerator
import spock.lang.Specification

class EmployeeServiceImplTest extends Specification {
    private EmployeeServiceImpl  employeeServiceImpl;
    private EmployeeRepository employeeRepository;
    def setup(){
        employeeRepository = Mock()
        employeeServiceImpl = new EmployeeServiceImpl(employeeRepository)
    }
    def "FindById test"() {
        given:
        def id = 1L
        Employee employee = new Employee();
        employee.setId(id)
        when:
        def result = employeeServiceImpl.findById(id)
        then:
        1 * employeeRepository.findById(id) >> Optional.of(employee)
        result == EmployeeMapper.entityToDto(employee)

    }
    def "FindById exception test"(){
        given:
        def id = 1L
        Employee employee = EmployeeGenerator.generateEmployee()
        when:
        def result = employeeServiceImpl.findById(id)
        then:
        1 * employeeRepository.findById(id) >> Optional.empty()
        def error = thrown(RuntimeException.class)
        error.message == "Not Found"
        result == null
    }

    def "Save test"() {
        given:
        EmployeeDto employeeDto = EmployeeDto.builder()
                .id(1L)
                .firstname("A")
                .lastname("B")
                .salary(1.2)
                .department("HR")
                .gender(Gender.FEMALE)
                .build();
        when:
        employeeServiceImpl.save(employeeDto)
        then:
        1 * employeeRepository.save(EmployeeMapper.dtoToEntity(employeeDto))

    }

    def "FindAllEmployees test"() {
       given:
       List<Employee> employees = EmployeeGenerator.generateEmployees(5)
       when:
       def res = employeeServiceImpl.findAllEmployees()
       then:
       1 * employeeRepository.findAll() >> employees
       res == EmployeeMapper.entitiesToDtos(employees)

    }
}
