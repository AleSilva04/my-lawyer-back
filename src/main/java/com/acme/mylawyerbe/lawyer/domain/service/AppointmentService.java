package com.acme.mylawyerbe.lawyer.domain.service;

import com.acme.mylawyerbe.lawyer.domain.model.entity.Appointment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

public interface AppointmentService {

    List<Appointment> getAll();

    Page<Appointment> getAll(Pageable pageable);

    List<Appointment> getAllByClientId(Long clientId);

    Page<Appointment> getAllByClientId(Long clientId, Pageable pageable);

    Appointment getByIdAndClientId(Long id, Long clientId);

    List<Appointment> getAllByLawyerId(Long lawyerId);

    Page<Appointment> getAllByLawyerId(Long lawyerId, Pageable pageable);

    Appointment findByIdAndLawyerId(Long id, Long lawyerId);

    Appointment create(Long clientId, Long lawyerId, Appointment appointment);

    Appointment update(Long clientId, Long lawyerId, Long appointmentId, Appointment appointment);

    ResponseEntity<?> delete(Long clientId, Long lawyerId, Long appointmentId);
}
