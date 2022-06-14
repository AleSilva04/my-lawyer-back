package com.acme.mylawyerbe.lawyer.service;

import com.acme.mylawyerbe.lawyer.domain.model.entity.FavouriteLawyer;
import com.acme.mylawyerbe.lawyer.domain.persistence.FavouriteLawyerRepository;
import com.acme.mylawyerbe.lawyer.domain.service.FavouriteLawyerService;
import com.acme.mylawyerbe.shared.exception.ResourceNotFoundException;
import com.acme.mylawyerbe.shared.exception.ResourceValidationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.util.List;
import java.util.Set;

@Service
public class FavouriteLawyerServiceImpl implements FavouriteLawyerService {

    private static final String ENTITY = "Appointment";
    private final FavouriteLawyerRepository favouriteLawyerRepository;
    private final Validator validator;

    public FavouriteLawyerServiceImpl(FavouriteLawyerRepository favouriteLawyerRepository, Validator validator) {
        this.favouriteLawyerRepository = favouriteLawyerRepository;
        this.validator = validator;
    }


    @Override
    public List<FavouriteLawyer> getAll() {
        return favouriteLawyerRepository.findAll();
    }

    @Override
    public Page<FavouriteLawyer> getAll(Pageable pageable) {
        return favouriteLawyerRepository.findAll(pageable);
    }

    @Override
    public List<FavouriteLawyer> getAllByClientId(Long clientId) {
        return favouriteLawyerRepository.findByClientId(clientId);
    }

    @Override
    public Page<FavouriteLawyer> getAllByClientId(Long clientId, Pageable pageable) {
        return favouriteLawyerRepository.findByClientId(clientId, pageable);
    }

    @Override
    public FavouriteLawyer getByIdAndClientId(Long id, Long clientId) {
        return favouriteLawyerRepository.findByIdAndClientId(id,clientId)
                .orElseThrow(() -> new ResourceNotFoundException(ENTITY, id));
    }

    @Override
    public List<FavouriteLawyer> getAllByLawyerId(Long lawyerId) {
        return favouriteLawyerRepository.findByLawyerId(lawyerId);
    }

    @Override
    public Page<FavouriteLawyer> getAllByLawyerId(Long lawyerId, Pageable pageable) {
        return favouriteLawyerRepository.findByLawyerId(lawyerId, pageable);
    }

    @Override
    public FavouriteLawyer findByIdAndLawyerId(Long id, Long lawyerId) {
        return favouriteLawyerRepository.findByIdAndLawyerId(id, lawyerId)
                .orElseThrow(() -> new ResourceNotFoundException(ENTITY, id));
    }

    @Override
    public FavouriteLawyer create(Long clientId, Long lawyerId, FavouriteLawyer favouriteLawyer) {
        Set<ConstraintViolation<FavouriteLawyer>> violations = validator.validate(favouriteLawyer);

        if(!violations.isEmpty())
            throw new ResourceValidationException(ENTITY, violations);

        return favouriteLawyerRepository.save(favouriteLawyer);
    }

    @Override
    public FavouriteLawyer update(Long clientId, Long lawyerId, Long favouriteLawyerId, FavouriteLawyer favouriteLawyer) {
        Set<ConstraintViolation<FavouriteLawyer>> violations = validator.validate(favouriteLawyer);

        if(!violations.isEmpty())
            throw new ResourceValidationException(ENTITY, violations);

        return favouriteLawyerRepository.findById(favouriteLawyerId).map(favouriteLawyerSave ->
                favouriteLawyerRepository.save(favouriteLawyerSave))
                .orElseThrow(() -> new ResourceNotFoundException(ENTITY, favouriteLawyerId));
    }

    @Override
    public ResponseEntity<?> delete(Long clientId, Long lawyerId, Long favouriteLawyerId) {
        return favouriteLawyerRepository.findById(favouriteLawyerId).map(favouriteLawyer ->{
                favouriteLawyerRepository.delete(favouriteLawyer);
                return ResponseEntity.ok().build();
        }).orElseThrow(() -> new ResourceNotFoundException(ENTITY, favouriteLawyerId));
    }
}
