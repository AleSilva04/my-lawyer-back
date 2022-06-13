package com.acme.mylawyerbe.lawyer.domain.service;

import com.acme.mylawyerbe.lawyer.domain.model.entity.Notification;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface NotificationService {

    List<Notification> getAll();

    Page<Notification> getAll(Pageable pageable);

    Notification getById(Long notificationId);

    Notification create(Notification notification);

    Notification update(Long notificationId, Notification request);

    ResponseEntity<?> delete(Long notificationId);
}
