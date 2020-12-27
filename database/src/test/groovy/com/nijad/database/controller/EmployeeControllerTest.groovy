package com.nijad.database.controller

import com.fasterxml.jackson.databind.ObjectMapper
import com.nijad.database.dao.enums.Gender
import com.nijad.database.model.EmployeeDto
import com.nijad.database.service.EmployeeService

import org.springframework.http.MediaType
import spock.lang.Specification
import org.springframework.test.web.servlet.MockMvc
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.*
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*


class EmployeeControllerTest extends Specification {
    EmployeeService employeeService
    EmployeeController employeeController
    MockMvc mockMvc
    ObjectMapper objectMapper;

    def setup(){
        objectMapper = new ObjectMapper()
        employeeService = Mock(EmployeeService)
        employeeController = new EmployeeController(employeeService)
        mockMvc = standaloneSetup(employeeController).build()
    }
    def "find All Employees"(){
        given:
        List<EmployeeDto> employeeDtos = new ArrayList<>()
        EmployeeDto employeeDto = EmployeeDto.builder()
                .id(1L)
                .firstname("A")
                .lastname("B")
                .department("IT")
                .salary(12.4)
                .gender(Gender.MALE)
                .build()
        employeeDtos.add(employeeDto)
        when:
        def response = mockMvc.perform(get("/employee"))
        then:
        1 * employeeService.findAllEmployees() >> employeeDtos
        response
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(content().string('[{"id":1,"firstname":"A","lastname":"B","gender":"MALE","salary":12.4,"department":"IT"}]'))

    }
    def "find by id"(){
        given:
        def id = 1L
        EmployeeDto employeeDto = EmployeeDto.builder()
                .id(id)
                .firstname("C")
                .lastname("D")
                .department("HR")
                .salary(13.1)
                .gender(Gender.FEMALE)
                .build()
        when:
        def response = mockMvc.perform(get("/employee/1"))
        then:
        1 * employeeService.findById(id) >> employeeDto
        response
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(content().string('{"id":1,"firstname":"C","lastname":"D","gender":"FEMALE","salary":13.1,"department":"HR"}'))
    }
    def "find by id not found test"(){
        given:
        def id = 1L
        when:
        def response = mockMvc.perform(get("/employee/1"))
        then:
        1 * employeeService.findById(id) >> new RuntimeException("Not Found")
        response.andExpect(status().isNotFound())
    }
    def "save test"(){
        given:
        def id = 1L
        EmployeeDto employeeDto = EmployeeDto.builder()
                .id(id)
                .firstname("C")
                .lastname("D")
                .department("HR")
                .salary(13.1)
                .gender(Gender.FEMALE)
                .build()
        String json = objectMapper.writeValueAsString(employeeDto)  //'{"id":1,"firstname":"C","lastname":"D","gender":"FEMALE","salary":13.1,"department":"HR"}'
        when:
        def result = mockMvc.perform(
                post("/employee")
                .content(json)
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))

        then:
        1 * employeeService.save(employeeDto)
        result.andExpect(status().isCreated())
    }
}
