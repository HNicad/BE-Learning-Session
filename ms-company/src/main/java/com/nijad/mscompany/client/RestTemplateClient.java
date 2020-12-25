package com.nijad.mscompany.client;

import com.nijad.mscompany.model.EmployeeDto;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Component
public class RestTemplateClient {

    private final RestTemplate restTemplate;

    public RestTemplateClient(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public List<EmployeeDto> getAllEmployees() {
        EmployeeDto[] responseEntity = restTemplate
                .getForEntity("http://localhost:8888/employee",EmployeeDto[].class).getBody();
        return Arrays.asList(responseEntity);
    }

    public EmployeeDto getEmployeeById(Long id) {
        HttpHeaders httpHeaders = new HttpHeaders();
        HttpEntity<EmployeeDto> httpEntity = new HttpEntity<>(httpHeaders);
        ResponseEntity<EmployeeDto> responseEntity = restTemplate
                .exchange("http://localhost:8888/employee/{id}", HttpMethod.GET,httpEntity,EmployeeDto.class,id);
        return  responseEntity.getBody();
    }

}
