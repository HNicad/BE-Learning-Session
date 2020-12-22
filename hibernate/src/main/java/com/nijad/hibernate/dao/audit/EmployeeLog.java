package com.nijad.hibernate.dao.audit;


import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "employee_log")
public class EmployeeLog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long employeeId;

    private String operationType;
    private Date date;
    public EmployeeLog() {
    }

    public EmployeeLog(Long employeeId, String operationType, Date date) {
        this.employeeId = employeeId;
        this.operationType = operationType;
        this.date = date;
    }

    public Long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Long employeeId) {
        this.employeeId = employeeId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOperationType() {
        return operationType;
    }

    public void setOperationType(String operationType) {
        this.operationType = operationType;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
