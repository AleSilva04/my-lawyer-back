package com.acme.mylawyerbe.lawyer.service;

import com.acme.mylawyerbe.lawyer.domain.model.entity.Specialty;
import com.acme.mylawyerbe.lawyer.domain.persistence.SpecialtyRepository;
import com.acme.mylawyerbe.lawyer.domain.service.SpecialtyService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.validation.Validator;
import java.util.List;

@Service
public class SpecialtyServiceImpl implements SpecialtyService {

    private static final String ENTITY = "Specialty";

    private final SpecialtyRepository specialtyRepository;

    private final Validator validator;

    public SpecialtyServiceImpl(SpecialtyRepository specialtyRepository, Validator validator) {
        this.specialtyRepository = specialtyRepository;
        this.validator = validator;
    }

    @Override
    public List<Specialty> getAll() {
        return specialtyRepository.findAll();
    }

    @Override
    public Page<Specialty> getAll(Pageable pageable) {
        return null;
    }

    @Override
    public Specialty getById(Long specialtyId) {
        return null;
    }

    @Override
    public Specialty getByName(String name) {
        return null;
    }

    @Override
    public Specialty create(Specialty specialty) {
        return null;
    }

    @Override
    public Specialty update(Long specialtyId, Specialty request) {
        return null;
    }

    @Override
    public ResponseEntity<?> delete(Long specialtyId) {
        return null;
    }
}
