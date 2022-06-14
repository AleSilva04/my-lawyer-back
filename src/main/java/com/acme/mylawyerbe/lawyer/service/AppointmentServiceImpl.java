package com.acme.mylawyerbe.lawyer.service;

import com.acme.mylawyerbe.lawyer.domain.model.entity.Appointment;
import com.acme.mylawyerbe.lawyer.domain.persistence.AppointmentRepository;
import com.acme.mylawyerbe.lawyer.domain.service.AppointmentService;
import com.acme.mylawyerbe.shared.exception.ResourceNotFoundException;
import com.acme.mylawyerbe.shared.exception.ResourceValidationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class AppointmentServiceImpl implements AppointmentService {

    private static final String ENTITY = "Appointment";
    private final AppointmentRepository appointmentRepository;
    private final Validator validator;

    public AppointmentServiceImpl(AppointmentRepository appointmentRepository, Validator validator) {
        this.appointmentRepository = appointmentRepository;
        this.validator = validator;
    }

    @Override
    public List<Appointment> getAll() {
        return appointmentRepository.findAll();
    }

    @Override
    public Page<Appointment> getAll(Pageable pageable) {
        return appointmentRepository.findAll(pageable);
    }

    @Override
    public List<Appointment> getAllByClientId(Long clientId) {
        return appointmentRepository.findByClientId(clientId);
    }

    @Override
    public Page<Appointment> getAllByClientId(Long clientId, Pageable pageable) {
        return appointmentRepository.findByClientId(clientId, pageable);
    }

    @Override
    public Appointment getByIdAndClientId(Long id, Long clientId) {
        return appointmentRepository.findByIdAndClientId(id, clientId)
                .orElseThrow(() -> new ResourceNotFoundException(ENTITY, id));
    }

    @Override
    public List<Appointment> getAllByLawyerId(Long lawyerId) {
        return appointmentRepository.findByLawyerId(lawyerId);
    }

    @Override
    public Page<Appointment> getAllByLawyerId(Long lawyerId, Pageable pageable) {
        return appointmentRepository.findByLawyerId(lawyerId, pageable);
    }

    @Override
    public Appointment findByIdAndLawyerId(Long id, Long lawyerId) {
        return appointmentRepository.findByIdAndLawyerId(id, lawyerId)
                .orElseThrow(() -> new ResourceNotFoundException(ENTITY, id));
    }

    @Override
    public Appointment create(Long clientId, Long lawyerId, Appointment appointment) {

        Set<ConstraintViolation<Appointment>> violations = validator.validate(appointment);

        if(!violations.isEmpty())
            throw new ResourceValidationException(ENTITY, violations);

        return appointmentRepository.save(appointment);

    }

    @Override
    public Appointment update(Long clientId, Long lawyerId, Long appointmentId, Appointment appointment) {
        Set<ConstraintViolation<Appointment>> violations = validator.validate(appointment);

        if(!violations.isEmpty())
            throw new ResourceValidationException(ENTITY, violations);

        return appointmentRepository.findById(appointmentId).map(appointmentSave ->
                appointmentRepository.save(appointmentSave.withDate(appointment.getDate())))
                .orElseThrow(() -> new ResourceNotFoundException(ENTITY, appointmentId));
    }

    @Override
    public ResponseEntity<?> delete(Long clientId, Long lawyerId, Long appointmentId) {
        return appointmentRepository.findById(appointmentId).map(appointment -> {
            appointmentRepository.delete(appointment);
            return ResponseEntity.ok().build();
        }).orElseThrow(() -> new ResourceNotFoundException(ENTITY, appointmentId));
    }
}
