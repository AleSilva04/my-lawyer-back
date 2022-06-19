package com.acme.mylawyerbe.lawyer.service;

import com.acme.mylawyerbe.lawyer.domain.model.entity.Appointment;
import com.acme.mylawyerbe.lawyer.domain.persistence.AppointmentRepository;
import com.acme.mylawyerbe.lawyer.domain.service.AppointmentService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.validation.Validator;
import java.util.List;

@Service
public class AppointmentServiceImpl implements AppointmentService {

    private static final String ENTITY = "Appointment";

    private final AppointmentRepository appointmentRepository;

    private final Validator validator;

    public AppointmentServiceImpl(AppointmentRepository appointmentRepository, Validator validator) {
        this.appointmentRepository = appointmentRepository;
        this.validator = validator;
    }

    //Aca las clases cambian un poco lo habra hecho en clase?
    @Override
    public List<Appointment> getAll() {
        return appointmentRepository.findAll();
    }

    @Override
    public List<Appointment> getAllByClientId(Long clientId) {
        return null;
    }

    @Override
    public Page<Appointment> getAllByClientId(Long clientId, Pageable pageable) {
        return null;
    }

    @Override
    public Appointment getById(Long appointmentId) {
        return null;
    }

    @Override
    public Appointment getByName(String name) {
        return null;
    }

    @Override
    public Appointment create(Long clientId, Appointment appointment) {
        return null;
    }

    @Override
    public Appointment update(Long clientId, Long appointmentId, Appointment request) {
        return null;
    }

    @Override
    public ResponseEntity<?> delete(Long clientId, Long appointmentId) {
        return null;
    }
}
