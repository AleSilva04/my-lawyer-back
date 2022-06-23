package com.acme.mylawyerbe.lawyer.service;

import com.acme.mylawyerbe.lawyer.domain.model.entity.FavoriteLawyer;
import com.acme.mylawyerbe.lawyer.domain.persistence.FavoriteLawyerRepository;
import com.acme.mylawyerbe.lawyer.domain.service.FavoriteLawyerService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.validation.Validator;
import java.util.List;

@Service
public class FavoriteLawyerServiceImpl implements FavoriteLawyerService {

    private static final String ENTITY = "FavoriteLawyer";

    private final FavoriteLawyerRepository favoriteLawyerRepository;

    private final Validator validator;

    public FavoriteLawyerServiceImpl(FavoriteLawyerRepository favoriteLawyerRepository, Validator validator) {
        this.favoriteLawyerRepository = favoriteLawyerRepository;
        this.validator = validator;
    }

    //Aca las clases cambian un poco lo habra hecho en clase?

    @Override
    public List<FavoriteLawyer> getAll() {
        return favoriteLawyerRepository.findAll();
    }

    @Override
    public List<FavoriteLawyer> getAllByClientId(Long clientId) {
        return null;
    }

    @Override
    public Page<FavoriteLawyer> getAllByClientId(Long clientId, Pageable pageable) {
        return null;
    }

    @Override
    public List<FavoriteLawyer> getAllByLawyerId(Long lawyerId) {
        return null;
    }

    @Override
    public Page<FavoriteLawyer> getAllByLawyerId(Long lawyerId, Pageable pageable) {
        return null;
    }

    @Override
    public FavoriteLawyer getById(Long favoriteLawyerId) {
        return null;
    }

    @Override
    public FavoriteLawyer create(Long lawyerId, Long clientId, FavoriteLawyer favoriteLawyer) {
        return null;
    }

    @Override
    public FavoriteLawyer update(Long lawyerId, Long clientId, Long favoriteLawyerId, FavoriteLawyer request) {
        return null;
    }

    @Override
    public ResponseEntity<?> delete(Long lawyerId, Long clientId, Long favoriteLawyerId) {
        return null;
    }
}
