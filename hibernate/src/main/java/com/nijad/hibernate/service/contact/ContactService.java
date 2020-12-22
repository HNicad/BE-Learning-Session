package com.nijad.hibernate.service.contact;

import com.nijad.hibernate.dao.entity.Contact;

import java.util.List;
import java.util.Optional;

public interface ContactService {
    List<Contact> findByEmployeeId(Long id);
    Optional<Contact> findById(Long id);
    Contact save(Contact contact);
}
