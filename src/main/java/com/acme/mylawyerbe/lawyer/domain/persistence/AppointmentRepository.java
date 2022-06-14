package com.acme.mylawyerbe.lawyer.domain.persistence;

import com.acme.mylawyerbe.lawyer.domain.model.entity.Appointment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AppointmentRepository extends JpaRepository<Appointment, Long> {

    List<Appointment> findByClientId(Long clientId);

    Page<Appointment> findByClientId(Long clientId, Pageable pageable);

    Optional<Appointment> findByIdAndClientId(Long id, Long clientId);

    List<Appointment> findByLawyerId(Long lawyerId);

    Page<Appointment> findByLawyerId(Long lawyerId, Pageable pageable);

    Optional<Appointment> findByIdAndLawyerId(Long id, Long lawyerId);
}
