package com.nijad.database.model;

import com.nijad.database.dao.enums.Gender;
import lombok.*;

@Data
@Builder
@NoArgsConstructor(access = AccessLevel.PACKAGE)
@AllArgsConstructor(access = AccessLevel.PACKAGE)
public class EmployeeDto {
    private Long id;
    private String firstname;
    private String lastname;
    private Gender gender;
    private Double salary;
    private String department;
}
