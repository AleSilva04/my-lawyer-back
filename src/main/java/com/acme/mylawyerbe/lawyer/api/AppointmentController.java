package com.acme.mylawyerbe.lawyer.api;

import com.acme.mylawyerbe.lawyer.domain.service.AppointmentService;
import com.acme.mylawyerbe.lawyer.mapping.AppointmentMapper;
import com.acme.mylawyerbe.lawyer.resource.AppointmentResource;
import com.acme.mylawyerbe.lawyer.resource.CreateAppointmentResource;
import com.acme.mylawyerbe.lawyer.resource.UpdateAppointmentResource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/v1/appointments")
public class AppointmentController {

    private final AppointmentService appointmentService;
    private final AppointmentMapper mapper;

    public AppointmentController(AppointmentService appointmentService, AppointmentMapper mapper) {
        this.appointmentService = appointmentService;
        this.mapper = mapper;
    }

    @GetMapping
    public Page<AppointmentResource> getAllStudents(Pageable pageable){
        return mapper.modelListPage(appointmentService.getAll(),pageable);
    }

    @PostMapping(value = "{clientId}/{lawyerId}")
    public ResponseEntity<AppointmentResource> createAppointment(@PathVariable Long clientId,@PathVariable Long lawyerId, CreateAppointmentResource resource){
        return new ResponseEntity<>(mapper.toResource(appointmentService.create(clientId, lawyerId, mapper.toModel(resource))), HttpStatus.CREATED);
    }

    @PutMapping("{appointmentId}")
    public AppointmentResource updateAppointment(@PathVariable Long appointmentId, UpdateAppointmentResource resource){
        return mapper.toResource(appointmentService.update(resource.getClient_id(), resource.getLawyer_id(), appointmentId, mapper.toModel(resource)));
    }

    @DeleteMapping("{appointmentId}/{clientId}/{lawyerId}")
    public ResponseEntity<?> deleteAppointment(@PathVariable Long clientId, @PathVariable Long lawyerId, @PathVariable Long appointmentId){
        return appointmentService.delete(clientId, lawyerId, appointmentId);
    }
}
