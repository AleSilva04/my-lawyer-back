package com.acme.mylawyerbe.lawyer.service;

import com.acme.mylawyerbe.lawyer.domain.model.entity.Notification;
import com.acme.mylawyerbe.lawyer.domain.persistence.NotificationRepository;
import com.acme.mylawyerbe.lawyer.domain.service.NotificationService;
import com.acme.mylawyerbe.shared.exception.ResourceNotFoundException;
import com.acme.mylawyerbe.shared.exception.ResourceValidationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

import javax.validation.ConstraintViolation;
import javax.xml.validation.Validator;
import java.util.List;
import java.util.Set;

public class NotificationServiceImpl implements NotificationService {

    private static final String ENTITY ="Notification";

    private final NotificationRepository notificationRepository;

    private final Validator validator;

    public NotificationServiceImpl(NotificationRepository notificationRepository, Validator validator){
        this.notificationRepository= notificationRepository;
        this.validator=validator;
    }

    @Override
    public List<Notification> getAll(){return  notificationRepository.findAll();}

    @Override
    public Page<Notification> getAll(Pageable pageable){
        return notificationRepository.findAll(pageable);
    }

    @Override
    public Notification getById(Long notificationId){
        return notificationRepository.findById(notificationId)
                .orElseThrow(() -> new ResourceNotFoundException(ENTITY, notificationId));
    }

    @Override
    public Notification create(Notification notification){
        Set<ConstraintViolation<Notification>> violations = validator.validate(notification);

        if(!violations.isEmpty())
            throw new ResourceValidationException(ENTITY, violations);

        //Name Uniqueness validation

        Notification notificationWithDate = notificationRepository.findAllByDate(notification.getDate());
        if (notificationWithDate != null)
            throw new ResourceValidationException(ENTITY,
                    "An notification with the same date already exists");
        return notificationRepository.save(notification);
    }

    @Override
    public Notification update(Long notificationId, Notification request){
        Set<ConstraintViolation<Notification>> violations = validator.validate(request);
        if (!violations.isEmpty())
            throw new ResourceValidationException(ENTITY, violations);

        Notification notificationWithDate = notificationRepository.findAllByDate(request.getDate());

        if (notificationWithDate != null && !notificationWithDate.getId().equals(notificationId))
            throw  new ResourceValidationException(ENTITY,
                    "An notification with the same date already exists");

        return notificationRepository.findById(notificationId).map(notification ->
                        notificationRepository.save(notification.withDate(request.getDate())
                                .withClientId(request.getClientId())
                                .withLawyerId(request.getLawyerId())))
                .orElseThrow(() -> new ResourceNotFoundException(ENTITY, notificationId));
    }

    @Override
    public ResponseEntity<?> delete(Long notificationId){

        return notificationRepository.findById(notificationId).map(student ->{
            notificationRepository.delete(student);
            return ResponseEntity.ok().build();
        }).orElseThrow(() -> new ResourceNotFoundException(ENTITY, notificationId));

    }


}
