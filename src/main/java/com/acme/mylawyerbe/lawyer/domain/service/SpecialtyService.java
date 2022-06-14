package com.acme.mylawyerbe.lawyer.domain.service;

import com.acme.mylawyerbe.lawyer.domain.model.entity.Specialty;
import com.acme.mylawyerbe.lawyer.domain.persistence.LawyerRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;

public interface SpecialtyService {
    public ArrayList<Specialty> obtenerSpecialty();

    public Specialty crearSpecialty(Specialty specialty);

    public void eliminarSpecialty(long idSpecialty);

    public Specialty actualizarSpecialty(Specialty specialty, long idSpecialty);
}
