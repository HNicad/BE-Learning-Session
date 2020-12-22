package com.nijad.hibernate.service.salary;

import com.nijad.hibernate.dao.entity.Salary;

import java.util.List;
import java.util.Optional;

public interface SalaryService {
    List<Salary> findByEmployeeId(Long id);
    Optional<Salary> findById(Long id);
    Salary save(Salary salary);
}
