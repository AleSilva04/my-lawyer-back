package com.acme.mylawyerbe.lawyer.domain.persistence;

import com.acme.mylawyerbe.lawyer.domain.model.entity.FavoriteLawyer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FavoriteLawyerRepository extends JpaRepository<FavoriteLawyer, Long> {
    //verificar que clases se necesita, buscar porqué?
    //solo seria necesario buscar por id del cliente
    //findBy vs findAllBy
    //yo creo que es finAllBy porque es una lista
    List<FavoriteLawyer> findAllByClient_Id(Long clientId);

    Page<FavoriteLawyer> findAllByClient_Id(Long clientId, Pageable pageable);
}
