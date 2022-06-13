package com.acme.mylawyerbe.lawyer.domain.persistence;

import com.acme.mylawyerbe.lawyer.domain.model.entity.Notification;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface NotificationRepository extends JpaRepository<Notification, Long> {
    @Override
    List<Notification> findAll();

    List<Notification> findAllByDate(String Date);

    Notification findByDate(String Date);

    Notification findByIds(Long idLawyer, Long idClient);

    Notification findByLawyerId(Long lawyerId);


}
