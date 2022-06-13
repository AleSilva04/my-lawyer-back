package com.acme.mylawyerbe.lawyer.api;

import com.acme.mylawyerbe.lawyer.domain.service.NotificationService;
import com.acme.mylawyerbe.lawyer.mapping.NotificationMapper;
import com.acme.mylawyerbe.lawyer.resource.CreateNotificationResource;
import com.acme.mylawyerbe.lawyer.resource.NotificationResource;
import com.acme.mylawyerbe.lawyer.resource.UpdateNotificationResource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value="api/v1/notifications")
public class NotificationsController {
    private final NotificationService notificationService;

    private final NotificationMapper mapper;

    public NotificationsController(NotificationService notificationService, NotificationMapper mapper){
        this.mapper = mapper;
        this.notificationService = notificationService;
    }

    @GetMapping
    public Page<NotificationResource> getAllNotifications(Pageable pageable){
        return mapper.modelListPage(notificationService.getAll(),pageable);
    }

    @GetMapping("{notificationId}")
    public NotificationResource getNotificationById(Long notificationId){
        return mapper.toResource(notificationService.getById(notificationId));
    }

    @PostMapping
    public ResponseEntity<NotificationResource> createNotification(CreateNotificationResource resource){
        return new ResponseEntity<>(mapper.toResource(notificationService.create(
                mapper.toModel(resource))), HttpStatus.CREATED);
    }

    @PutMapping("{notificationId}")
    public NotificationResource updateNotificationP(Long notificationId, UpdateNotificationResource resource){
        return mapper.toResource(notificationService.update(notificationId, mapper.toModel(resource)));
    }

    @DeleteMapping("{studentId}")
    public ResponseEntity<?> deleteNotification(Long notificationId){
        return notificationService.delete(notificationId);
    }

}
