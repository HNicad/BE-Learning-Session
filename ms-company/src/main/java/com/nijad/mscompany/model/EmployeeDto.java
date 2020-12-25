package com.nijad.mscompany.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import lombok.Data;

import java.time.LocalDate;

@ApiModel("Employee Information")
@Data
public class EmployeeDto {
    @JsonProperty("id")
    private Long id;
    @JsonProperty("name")
    private String name;
    @JsonProperty("surname")
    private String surname;
    @JsonProperty("male")
    private boolean isMale;
    @JsonProperty("birthDate")
    private LocalDate birthDate;
}
