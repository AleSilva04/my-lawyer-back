package com.acme.mylawyerbe.lawyer.domain.service;

import com.acme.mylawyerbe.lawyer.domain.model.entity.FavouriteLawyer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface FavouriteLawyerService {

    List<FavouriteLawyer> getAll();

    Page<FavouriteLawyer> getAll(Pageable pageable);

    List<FavouriteLawyer> getAllByClientId(Long clientId);

    Page<FavouriteLawyer> getAllByClientId(Long clientId, Pageable pageable);

    FavouriteLawyer getByIdAndClientId(Long id, Long clientId);

    List<FavouriteLawyer> getAllByLawyerId(Long lawyerId);

    Page<FavouriteLawyer> getAllByLawyerId(Long lawyerId, Pageable pageable);

    FavouriteLawyer findByIdAndLawyerId(Long id, Long lawyerId);

    FavouriteLawyer create(Long clientId, Long lawyerId, FavouriteLawyer favouriteLawyer);

    FavouriteLawyer update(Long clientId, Long lawyerId, Long favouriteLawyerId, FavouriteLawyer favouriteLawyer);

    ResponseEntity<?> delete(Long clientId, Long lawyerId, Long favouriteLawyerId);
}
