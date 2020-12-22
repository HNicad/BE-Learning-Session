package com.nijad.hibernate.service.log;


import com.nijad.hibernate.dao.audit.EmployeeLog;

public interface EmployeeLogService {
    EmployeeLog save(EmployeeLog employeeLog);
}
