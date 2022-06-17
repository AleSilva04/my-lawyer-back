package com.acme.mylawyerbe.lawyer.domain.service;

import com.acme.mylawyerbe.lawyer.domain.model.entity.Contact;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ContactService {

    List<Contact> getAll();

    List<Contact> getAllByClientId(Long clientId);

    Page<Contact> getAllByClientId(Long clientId, Pageable pageable);

    //falta por lawyerId

    Contact getById(Long contactId);

    Contact getByName(String name);

    //crud

    //tambien se tiene que agregar el "Long lawyerId"
    Contact create(Long clientId, Contact contact);

    //tambien se tiene que agregar el "Long lawyerId"
    Contact update(Long clientId, Long contactId, Contact request);

    //tambien se tiene que agregar el "Long lawyerId"
    ResponseEntity<?> delete(Long clientId, Long contactId);
}
