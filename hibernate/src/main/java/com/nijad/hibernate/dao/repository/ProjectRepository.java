package com.nijad.hibernate.dao.repository;

import com.nijad.hibernate.dao.entity.Contact;
import com.nijad.hibernate.dao.entity.Project;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProjectRepository extends CrudRepository<Project,Long> {
    List<Project> findByEmployeeId(Long employeeId);
}
