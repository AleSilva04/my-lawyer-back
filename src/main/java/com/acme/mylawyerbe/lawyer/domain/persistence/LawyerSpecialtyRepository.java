package com.acme.mylawyerbe.lawyer.domain.persistence;

import com.acme.mylawyerbe.lawyer.domain.model.entity.LawyerSpecialty;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LawyerSpecialtyRepository extends CrudRepository
        <LawyerSpecialty, Long>{

}