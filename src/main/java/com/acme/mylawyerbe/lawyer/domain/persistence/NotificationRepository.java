package com.acme.mylawyerbe.lawyer.domain.persistence;

import com.acme.mylawyerbe.lawyer.domain.model.entity.Notification;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface NotificationRepository extends JpaRepository<Notification, Long> {
    //verificar que clases se necesita, buscar porqué?
    //solo seria necesario buscar por id del cliente
    //yo creo que es finAllBy porque es una lista
    List<Notification> findAllByClient_Id(Long clientId);

    Page<Notification> findAllByClient_Id(Long clientId, Pageable pageable);
}
