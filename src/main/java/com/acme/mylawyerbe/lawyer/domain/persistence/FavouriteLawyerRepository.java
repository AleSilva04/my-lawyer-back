package com.acme.mylawyerbe.lawyer.domain.persistence;

import com.acme.mylawyerbe.lawyer.domain.model.entity.FavouriteLawyer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface FavouriteLawyerRepository extends JpaRepository<FavouriteLawyer, Long> {

    List<FavouriteLawyer> findByClientId(Long clientId);

    Page<FavouriteLawyer> findByClientId(Long clientId, Pageable pageable);

    Optional<FavouriteLawyer> findByIdAndClientId(Long id, Long clientId);

    List<FavouriteLawyer> findByLawyerId(Long lawyerId);

    Page<FavouriteLawyer> findByLawyerId(Long lawyerId, Pageable pageable);

    Optional<FavouriteLawyer> findByIdAndLawyerId(Long id, Long lawyerId);
}
