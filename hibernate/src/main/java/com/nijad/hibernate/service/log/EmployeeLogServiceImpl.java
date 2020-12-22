package com.nijad.hibernate.service.log;

import com.nijad.hibernate.dao.audit.EmployeeLog;
import com.nijad.hibernate.dao.repository.EmployeeLogRepository;
import org.springframework.stereotype.Service;

@Service
public class EmployeeLogServiceImpl implements EmployeeLogService {
    private final EmployeeLogRepository employeeLogRepository;

    public EmployeeLogServiceImpl(EmployeeLogRepository employeeLogRepository) {
        this.employeeLogRepository = employeeLogRepository;
    }

    @Override
    public EmployeeLog save(EmployeeLog employeeLog) {
        return employeeLogRepository.save(employeeLog);
    }
}
