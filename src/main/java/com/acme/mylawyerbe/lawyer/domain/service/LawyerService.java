package com.acme.mylawyerbe.lawyer.domain.service;

import com.acme.mylawyerbe.lawyer.domain.model.entity.Lawyer;
import com.acme.mylawyerbe.lawyer.domain.persistence.LawyerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Objects;

@Service
public class LawyerService {
    @Autowired
    LawyerRepository lawyerRepository;

    public ArrayList<Lawyer> obtenerLawyers(){
        return (ArrayList<Lawyer>) lawyerRepository.findAll();
    }

    public Lawyer crearLawyer(Lawyer lawyer){
        return lawyerRepository.save(lawyer);
    }

    public void eliminarLawyer(long idLawyer){
        lawyerRepository.deleteById(idLawyer);
    }

    public Lawyer actualizarLawyer(Lawyer lawyer, long idLawyer) {
        Lawyer lawyerfind = lawyerRepository.findById(idLawyer)
                .get();
        if (Objects.nonNull(lawyer.getFullName())
                && !"".equalsIgnoreCase(
                lawyer.getFullName())) {

            lawyerfind.setFullName(
                    lawyer.getFullName());
        }

        if (Objects.nonNull(lawyer.getAddress())
                && !"".equalsIgnoreCase(
                lawyer.getAddress())) {

            lawyerfind.setAddress(
                    lawyer.getAddress());
        }

        if (Objects.nonNull(lawyer.getAge())
                && !"".equalsIgnoreCase(
                Integer.toString(lawyer.getAge()))) {

            lawyerfind.setAge(
                    lawyer.getAge());
        }

        if (Objects.nonNull(lawyer.getEmail())
                && !"".equalsIgnoreCase(
                lawyer.getEmail())) {

            lawyerfind.setEmail(
                    lawyer.getEmail());
        }

        if (Objects.nonNull(lawyer.getPoints())
                && !"".equalsIgnoreCase(
                Integer.toString(lawyer.getPoints()))) {

            lawyerfind.setPoints(
                    lawyer.getPoints());
        }

        if (Objects.nonNull(lawyer.getImage())
                && !"".equalsIgnoreCase(
                lawyer.getImage())) {

            lawyerfind.setImage(
                    lawyer.getImage());
        }

            return lawyerRepository.save(lawyerfind);
    }
}
