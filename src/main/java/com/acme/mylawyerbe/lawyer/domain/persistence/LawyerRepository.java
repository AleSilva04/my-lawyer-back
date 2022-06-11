package com.acme.mylawyerbe.lawyer.domain.persistence;


import com.acme.mylawyerbe.lawyer.domain.model.entity.Lawyer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LawyerRepository extends CrudRepository
<Lawyer, Long>{

}
