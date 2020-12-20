package com.nijad.database.dao.repository;

import com.nijad.database.dao.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Long> {
    @Transactional
    @Modifying
    @Query(value = "update Employee e set e.firstname = :firstname where e.id = :id ")
    int updateEmployee(@Param("id") Long id, @Param("firstname") String firstname);
}
