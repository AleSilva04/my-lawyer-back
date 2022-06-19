package com.acme.mylawyerbe.lawyer.service;

import com.acme.mylawyerbe.lawyer.domain.model.entity.Notification;
import com.acme.mylawyerbe.lawyer.domain.persistence.NotificationRepository;
import com.acme.mylawyerbe.lawyer.domain.service.NotificationService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.validation.Validator;
import java.util.List;

@Service
public class NotificationServiceImpl implements NotificationService {

    private static final String ENTITY = "Notification";

    private final NotificationRepository notificationRepository;

    private final Validator validator;

    public NotificationServiceImpl(NotificationRepository notificationRepository, Validator validator) {
        this.notificationRepository = notificationRepository;
        this.validator = validator;
    }

    @Override
    public List<Notification> getAll() {
        return null;
    }

    @Override
    public List<Notification> getAllByClientId(Long clientId) {
        return null;
    }

    @Override
    public Page<Notification> getAllByClientId(Long clientId, Pageable pageable) {
        return null;
    }

    @Override
    public Notification getById(Long notificationId) {
        return null;
    }

    @Override
    public Notification getByName(String name) {
        return null;
    }

    @Override
    public Notification create(Long clientId, Notification notification) {
        return null;
    }

    @Override
    public Notification update(Long clientId, Long notificationId, Notification request) {
        return null;
    }

    @Override
    public ResponseEntity<?> delete(Long clientId, Long notificationId) {
        return null;
    }
}
