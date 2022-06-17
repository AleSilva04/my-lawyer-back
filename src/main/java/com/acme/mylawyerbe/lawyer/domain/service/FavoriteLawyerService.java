package com.acme.mylawyerbe.lawyer.domain.service;

import com.acme.mylawyerbe.lawyer.domain.model.entity.FavoriteLawyer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface FavoriteLawyerService {

    List<FavoriteLawyer> getAll();

    List<FavoriteLawyer> getAllByClientId(Long clientId);

    Page<FavoriteLawyer> getAllByClientId(Long clientId, Pageable pageable);

    //falta por lawyerId

    FavoriteLawyer getById(Long favoriteLawyerId);

    FavoriteLawyer getByName(String name);

    //crud

    //tambien se tiene que agregar el "Long lawyerId"
    FavoriteLawyer create(Long clientId, FavoriteLawyer favoriteLawyer);

    //tambien se tiene que agregar el "Long lawyerId"
    FavoriteLawyer update(Long clientId, Long favoriteLawyerId, FavoriteLawyer request);

    //tambien se tiene que agregar el "Long lawyerId"
    ResponseEntity<?> delete(Long clientId, Long favoriteLawyerId);
}
