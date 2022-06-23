package com.acme.mylawyerbe.lawyer.service;

import com.acme.mylawyerbe.lawyer.domain.model.entity.LawyerSpecialty;
import com.acme.mylawyerbe.lawyer.domain.persistence.LawyerSpecialtyRepository;
import com.acme.mylawyerbe.lawyer.domain.service.LawyerSpecialtyService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.validation.Validator;
import java.util.List;

@Service
public class LawyerSpecialtyServiceImpl implements LawyerSpecialtyService {

    private static final String ENTITY = "LawyerSpecialty";

    private final LawyerSpecialtyRepository lawyerSpecialtyRepository;

    private final Validator validator;

    public LawyerSpecialtyServiceImpl(LawyerSpecialtyRepository lawyerSpecialtyRepository, Validator validator) {
        this.lawyerSpecialtyRepository = lawyerSpecialtyRepository;
        this.validator = validator;
    }

    @Override
    public List<LawyerSpecialty> getAll() {
        return lawyerSpecialtyRepository.findAll();
    }

    @Override
    public List<LawyerSpecialty> getAllByLawyerId(Long lawyerId) {
        return null;
    }

    @Override
    public Page<LawyerSpecialty> getAllByLawyerId(Long lawyerId, Pageable pageable) {
        return null;
    }

    @Override
    public List<LawyerSpecialty> getAllBySpecialtyId(Long specialtyId) {
        return null;
    }

    @Override
    public Page<LawyerSpecialty> getAllBySpecialtyId(Long specialtyId, Pageable pageable) {
        return null;
    }

    @Override
    public LawyerSpecialty getById(Long lawyerSpecialtyId) {
        return null;
    }

    @Override
    public LawyerSpecialty create(Long lawyerId, Long specialtyId, LawyerSpecialty lawyerSpecialty) {
        return null;
    }

    @Override
    public LawyerSpecialty update(Long lawyerId, Long specialtyId, Long lawyerSpecialtyId, LawyerSpecialty request) {
        return null;
    }

    @Override
    public ResponseEntity<?> delete(Long lawyerId, Long specialtyId, Long lawyerSpecialtyId) {
        return null;
    }
}
