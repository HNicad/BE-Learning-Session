package com.nijad.mscompany.client;


import com.nijad.mscompany.model.EmployeeDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
@FeignClient(name = "employeeClient",url = "${service.url}")
public interface EmployeeFeignClient {
    @GetMapping
    List<EmployeeDto> getAllEmployees();
    @GetMapping(value = "/{id}")
    EmployeeDto getEmployeeById(@PathVariable Long id);
}
