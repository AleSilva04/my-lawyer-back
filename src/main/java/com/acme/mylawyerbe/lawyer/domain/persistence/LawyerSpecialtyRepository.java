package com.acme.mylawyerbe.lawyer.domain.persistence;

import com.acme.mylawyerbe.lawyer.domain.model.entity.LawyerSpecialty;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LawyerSpecialtyRepository extends JpaRepository<LawyerSpecialty, Long> {

    List<LawyerSpecialty> findAllByLawyer_Id(Long lawyerId);

    Page<LawyerSpecialty> findAllByLawyer_Id(Long lawyerId, Pageable pageable);

    List<LawyerSpecialty> findAllBySpecialty_Id(Long specialtyId);

    Page<LawyerSpecialty> findAllBySpecialty_Id(Long specialtyId, Pageable pageable);

}