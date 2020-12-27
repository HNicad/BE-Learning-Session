package com.nijad.database.mapper

import com.nijad.database.dao.entity.Employee
import com.nijad.database.dao.enums.Gender
import com.nijad.database.model.EmployeeDto
import com.nijad.database.util.EmployeeGenerator
import spock.lang.Specification


// add test util
class EmployeeMapperTest extends Specification {
    def "DtoToEntity test"() {
        given:
        EmployeeDto employeeDto = EmployeeDto.builder()
                .id(1L)
                .firstname("A")
                .lastname("B")
                .department("HR")
                .gender(Gender.MALE)
                .salary(3.5)
                .build();
        when:
        Employee employee = EmployeeMapper.dtoToEntity(employeeDto)
        then:
        employee.id == 1L
        employee.firstname == "A"
        employee.lastname == "B"
        employee.department == "HR"
        employee.gender == Gender.MALE
        employee.salary == 3.5

    }
    def "EntityToDto test"() {
        given:
        Employee employee = EmployeeGenerator.generateEmployee()
        when:
        EmployeeDto employeeDto = EmployeeMapper.entityToDto(employee)
        then:
        employeeDto.id == employee.id
        employeeDto.firstname == employee.firstname
        employeeDto.lastname == employee.lastname
        employeeDto.department == employee.department
        employeeDto.gender == employee.gender
        employeeDto.salary == employee.salary
    }
}
