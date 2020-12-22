package com.nijad.hibernate.dao.repository;


import com.nijad.hibernate.dao.entity.Contact;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ContactRepository extends CrudRepository<Contact,Long> {
    List<Contact> findByEmployeeId(Long employeeId);
}
