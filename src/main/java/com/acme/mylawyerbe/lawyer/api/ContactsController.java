package com.acme.mylawyerbe.lawyer.api;

import com.acme.mylawyerbe.lawyer.domain.service.ContactService;
import com.acme.mylawyerbe.lawyer.mapping.ContactMapper;
import com.acme.mylawyerbe.lawyer.resource.ContactResource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "api/v1/contacts")
public class ContactsController {

    private final ContactService contactService;

    private final ContactMapper mapper;

    public ContactsController(ContactService contactService, ContactMapper mapper) {
        this.contactService = contactService;
        this.mapper = mapper;
    }

    @GetMapping
    public Page<ContactResource> getAllContact(Pageable pageable){
        return mapper.modelListPage(contactService.getAll(), pageable);
    }
}
