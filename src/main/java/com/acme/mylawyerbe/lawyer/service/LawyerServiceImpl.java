package com.acme.mylawyerbe.lawyer.service;

import com.acme.mylawyerbe.lawyer.domain.model.entity.Lawyer;
import com.acme.mylawyerbe.lawyer.domain.persistence.LawyerRepository;
import com.acme.mylawyerbe.lawyer.domain.service.LawyerService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.validation.Validator;
import java.util.List;

@Service
public class LawyerServiceImpl implements LawyerService {

    private static final String ENTITY = "Lawyer";

    private final LawyerRepository lawyerRepository;

    private final Validator validator;


    public LawyerServiceImpl(LawyerRepository lawyerRepository, Validator validator) {
        this.lawyerRepository = lawyerRepository;
        this.validator = validator;
    }

    @Override
    public List<Lawyer> getAll() {
        return lawyerRepository.findAll();
    }

    @Override
    public Page<Lawyer> getAll(Pageable pageable) {
        return null;
    }

    @Override
    public Lawyer getById(Long lawyerId) {
        return null;
    }

    @Override
    public Lawyer getByFirstName(String firstName) {
        return null;
    }

    @Override
    public Lawyer getByLastName(String lastName) {
        return null;
    }

    @Override
    public Lawyer create(Lawyer lawyer) {
        return null;
    }

    @Override
    public Lawyer update(Long lawyerId, Lawyer request) {
        return null;
    }

    @Override
    public ResponseEntity<?> delete(Long lawyerId) {
        return null;
    }
}
