package com.acme.mylawyerbe.lawyer.domain.persistence;

import com.acme.mylawyerbe.lawyer.domain.model.entity.Appointment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface AppointmentRepository extends JpaRepository<Appointment, Long> {

    //verificar que clases se necesita, buscar porqué?
    //solo seria necesario buscar por id del cliente
    //findBy vs findAllBy
    //yo creo que es finAllBy porque es una lista
    List<Appointment> findAllByClient_Id(Long clientId);

    Page<Appointment> findAllByClient_Id(Long clientId, Pageable pageable);

    //Optional<Appointment> findByIdAndClient_Id(Long id, Long clientId);
}
