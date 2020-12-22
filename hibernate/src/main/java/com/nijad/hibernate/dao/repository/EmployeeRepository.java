package com.nijad.hibernate.dao.repository;

import com.nijad.hibernate.dao.entity.Employee;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends CrudRepository<Employee,Long> {
}
