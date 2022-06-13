package com.acme.mylawyerbe.lawyer.domain.service;

import com.acme.mylawyerbe.lawyer.domain.model.entity.Lawyer;
import com.acme.mylawyerbe.lawyer.domain.persistence.LawyerRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;

public interface LawyerService {
    public ArrayList<Lawyer> obtenerLawyers();

    public Lawyer crearLawyer(Lawyer lawyer);

    public void eliminarLawyer(long idLawyer);

    public Lawyer actualizarLawyer(Lawyer lawyer, long idLawyer);
}
