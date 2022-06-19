package com.acme.mylawyerbe.lawyer.domain.service;

import com.acme.mylawyerbe.lawyer.domain.model.entity.Appointment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface AppointmentService {

    //opciones de lectura
    List<Appointment> getAll();

    List<Appointment> getAllByClientId(Long clientId);

    Page<Appointment> getAllByClientId(Long clientId, Pageable pageable);

    //falta por lawyerId

    Appointment getById(Long appointmentId);

    Appointment getByName(String name);

    //opciones crud

    //tambien se tiene que agregar el "Long lawyerId"
    Appointment create(Long clientId, Appointment appointment);

    //tambien se tiene que agregar el "Long lawyerId"
    Appointment update(Long clientId, Long appointmentId, Appointment request);

    //tambien se tiene que agregar el "Long lawyerId"
    ResponseEntity<?> delete(Long clientId, Long appointmentId);
}