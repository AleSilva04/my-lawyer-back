package com.acme.mylawyerbe.lawyer.service;

import com.acme.mylawyerbe.lawyer.domain.model.entity.Lawyer;
import com.acme.mylawyerbe.lawyer.domain.model.entity.Specialty;
import com.acme.mylawyerbe.lawyer.domain.persistence.LawyerRepository;
import com.acme.mylawyerbe.lawyer.domain.persistence.SpecialtyRepository;
import com.acme.mylawyerbe.lawyer.domain.service.LawyerService;
import com.acme.mylawyerbe.lawyer.domain.service.SpecialtyService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.Objects;

public class SpecialtyServiceImpl implements SpecialtyService {
    @Autowired
    SpecialtyRepository specialtyRepository;

    public ArrayList<Specialty> obtenerSpecialty(){
        return (ArrayList<Specialty>) specialtyRepository.findAll();
    }

    public Specialty crearSpecialty(Specialty specialty){
        return specialtyRepository.save(specialty);
    }

    public void eliminarSpecialty(long idSpecialty){
        specialtyRepository.deleteById(idSpecialty);
    }

    public Specialty actualizarSpecialty(Specialty specialty, long idSpecialty) {
        Specialty specialtyfind = specialtyRepository.findById(idSpecialty)
                .get();
        if (Objects.nonNull(specialty.getSpecialty())
                && !"".equalsIgnoreCase(
                specialty.getSpecialty())) {

            specialtyfind.setSpecialty(
                    specialty.getSpecialty());
        }
        return specialtyRepository.save(specialtyfind);
    }
}
