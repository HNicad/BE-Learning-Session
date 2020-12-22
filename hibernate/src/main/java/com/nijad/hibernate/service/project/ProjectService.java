package com.nijad.hibernate.service.project;


import com.nijad.hibernate.dao.entity.Project;

import java.util.List;
import java.util.Optional;

public interface ProjectService {
    List<Project> findByEmployeeId(Long id);
    Optional<Project> findById(Long id);
    Project save(Project project);
}
