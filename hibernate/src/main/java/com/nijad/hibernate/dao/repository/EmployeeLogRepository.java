package com.nijad.hibernate.dao.repository;

import com.nijad.hibernate.dao.audit.EmployeeLog;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeLogRepository extends CrudRepository<EmployeeLog,Long> {

}
