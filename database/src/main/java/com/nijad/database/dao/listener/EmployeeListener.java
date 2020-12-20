package com.nijad.database.dao.listener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

public class EmployeeListener {
    Logger logger = LoggerFactory.getLogger(EmployeeListener.class);
    @PrePersist
    void beforePersist(Object o){
        logger.info("Persisting Employee");
    }
    @PreUpdate
    void beforeUpdate(Object o){
        logger.info("Updating Employee");
    }
}
