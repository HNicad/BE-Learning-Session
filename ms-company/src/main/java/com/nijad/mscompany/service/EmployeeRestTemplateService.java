package com.nijad.mscompany.service;

import com.nijad.mscompany.client.RestTemplateClient;
import com.nijad.mscompany.model.EmployeeDto;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
@Profile("dev")
@Service
public class EmployeeRestTemplateService implements EmployeeService{
    private final RestTemplateClient restTemplateClient;

    public EmployeeRestTemplateService(RestTemplateClient restTemplateClient) {
        this.restTemplateClient = restTemplateClient;
    }

    @Override
    public List<EmployeeDto> getAllEmployees() {
        return restTemplateClient.getAllEmployees();
    }

    @Override
    public EmployeeDto getEmployeeById(Long id) {
        return restTemplateClient.getEmployeeById(id);
    }
}
