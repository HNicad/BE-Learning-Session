package com.nijad.hibernate.dao.audit;


import com.nijad.hibernate.dao.entity.Employee;
import com.nijad.hibernate.dao.repository.EmployeeLogRepository;
import com.nijad.hibernate.service.BeanUtil;

import javax.persistence.PostPersist;
import javax.persistence.PostRemove;
import javax.persistence.PostUpdate;
import java.util.Date;
public class EmployeeListener {

    public EmployeeListener() {

    }

    @PostPersist
    public void postPersist(final Employee employee){
        saveInfo(employee.getId(),"persist");
    }
    @PostUpdate
    public void postUpdate(final Employee employee){
        saveInfo(employee.getId(),"update");
    }
    @PostRemove
    public void postRemove(final Employee employee){
        saveInfo(employee.getId(),"remove");
    }

    void saveInfo(Long employeeId,String type){
        EmployeeLogRepository employeeLogRepository =(EmployeeLogRepository)BeanUtil.getBean("employeeLogRepository");
        EmployeeLog employeeLog = new EmployeeLog();
        employeeLog.setOperationType(type);
        employeeLog.setEmployeeId(employeeId);
        employeeLog.setDate(new Date());
        employeeLogRepository.save(employeeLog);
    }

}
