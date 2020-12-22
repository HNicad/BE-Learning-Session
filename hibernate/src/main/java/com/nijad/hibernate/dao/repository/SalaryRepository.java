package com.nijad.hibernate.dao.repository;

import com.nijad.hibernate.dao.entity.Salary;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SalaryRepository extends CrudRepository<Salary,Long> {
    List<Salary> findByEmployeeId(Long studentId);
}
