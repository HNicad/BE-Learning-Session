package com.nijad.hibernate.service.contact;

import com.nijad.hibernate.dao.entity.Contact;
import com.nijad.hibernate.dao.repository.ContactRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ContactServiceImpl implements ContactService {
    private final ContactRepository contactRepository;

    public ContactServiceImpl(ContactRepository contactRepository) {
        this.contactRepository = contactRepository;
    }

    @Override
    public List<Contact> findByEmployeeId(Long id) {
        return contactRepository.findByEmployeeId(id);
    }

    @Override
    public Optional<Contact> findById(Long id) {
        return contactRepository.findById(id);
    }

    @Override
    public Contact save(Contact contact) {
        return contactRepository.save(contact);
    }
}
