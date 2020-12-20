package com.nijad.database.mapper;


import com.nijad.database.dao.entity.Employee;
import com.nijad.database.model.EmployeeDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

@Mapper
public interface EmployeeMapper {
    EmployeeMapper INSTANCE = Mappers.getMapper(EmployeeMapper.class);
    @Mappings({
            @Mapping(target = "id", source = "employee.id"),
            @Mapping(target = "firstname",source = "employee.firstname"),
            @Mapping(target = "lastname",source = "employee.lastname"),
            @Mapping(target = "gender",source = "employee.gender"),
            @Mapping(target = "salary",source = "employee.salary"),
            @Mapping(target = "department",source = "employee.department"),
    })
    EmployeeDto employeeToEmployeeDto(Employee employee);
    @Mappings({
            @Mapping(target = "id", source = "employeeDto.id"),
            @Mapping(target = "firstname",source = "employeeDto.firstname"),
            @Mapping(target = "lastname",source = "employeeDto.lastname"),
            @Mapping(target = "gender",source = "employeeDto.gender"),
            @Mapping(target = "salary",source = "employeeDto.salary"),
            @Mapping(target = "department",source = "employeeDto.department"),
    })
    Employee  employeeDtoToEmployee(EmployeeDto employeeDto);
}
