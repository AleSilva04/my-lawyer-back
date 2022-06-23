package com.acme.mylawyerbe.lawyer.service;

import com.acme.mylawyerbe.lawyer.domain.model.entity.Contact;
import com.acme.mylawyerbe.lawyer.domain.persistence.ContactRepository;
import com.acme.mylawyerbe.lawyer.domain.service.ContactService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.validation.Validator;
import java.util.List;

@Service
public class ContactServiceImpl implements ContactService {

    private static final String ENTITY = "Contact";

    private final ContactRepository contactRepository;

    private final Validator validator;

    public ContactServiceImpl(ContactRepository contactRepository, Validator validator) {
        this.contactRepository = contactRepository;
        this.validator = validator;
    }

    //Aca las clases cambian un poco lo habra hecho en clase?

    @Override
    public List<Contact> getAll() {
        return contactRepository.findAll();
    }

    @Override
    public List<Contact> getAllByClientId(Long clientId) {
        return null;
    }

    @Override
    public Page<Contact> getAllByClientId(Long clientId, Pageable pageable) {
        return null;
    }

    @Override
    public List<Contact> getAllByLawyerId(Long lawyerId) {
        return null;
    }

    @Override
    public Page<Contact> getAllByLawyerId(Long lawyerId, Pageable pageable) {
        return null;
    }

    @Override
    public Contact getById(Long contactId) {
        return null;
    }

    @Override
    public Contact getByName(String name) {
        return null;
    }

    @Override
    public Contact create(Long lawyerId, Long clientId, Contact contact) {
        return null;
    }

    @Override
    public Contact update(Long lawyerId, Long clientId, Long contactId, Contact request) {
        return null;
    }

    @Override
    public ResponseEntity<?> delete(Long lawyerId, Long clientId, Long contactId) {
        return null;
    }

}
