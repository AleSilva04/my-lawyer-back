package com.acme.mylawyerbe.lawyer.api;

import com.acme.mylawyerbe.lawyer.domain.service.AppointmentService;
import com.acme.mylawyerbe.lawyer.mapping.AppointmentMapper;
import com.acme.mylawyerbe.lawyer.resource.AppointmentResource;
import com.acme.mylawyerbe.lawyer.resource.CreateAppointmentResource;
import com.acme.mylawyerbe.lawyer.resource.UpdateAppointmentResource;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@SecurityRequirement(name = "acme")
@RestController
@RequestMapping("/api/v1/clients/{clientId}/appointment")
@Tag(name = "Clients", description = "Create, read, update and delete clients")
public class ClientAppointmentsController {

    private final AppointmentService appointmentService;

    private final AppointmentMapper mapper;

    public ClientAppointmentsController(AppointmentService appointmentService, AppointmentMapper mapper) {
        this.appointmentService = appointmentService;
        this.mapper = mapper;
    }

    @PreAuthorize("hasRole('USER') or hasRole('INSTRUCTOR') or hasRole('ADMIN')")
    @GetMapping
    public Page<AppointmentResource> getAllAppointmentByClientId(@PathVariable Long clientId, Pageable pageable){
        return mapper.modelListPage(appointmentService.getAllByClientId(clientId), pageable);
    }

    @PreAuthorize("hasRole('USER') or hasRole('INSTRUCTOR') or hasRole('ADMIN')")
    @GetMapping
    public Page<AppointmentResource> getAllAppointmentByLawyerId(@PathVariable Long lawyerId, Pageable pageable){
        return mapper.modelListPage(appointmentService.getAllByLawyerId(lawyerId), pageable);
    }

    @PreAuthorize("hasRole('INSTRUCTOR') or hasRole('ADMIN')")
    @PostMapping
    public AppointmentResource createAppointment(@PathVariable Long lawyerId,
                                                 @PathVariable Long clientId,
                                                 @RequestBody CreateAppointmentResource resource){
        return mapper.toResource(appointmentService.create(lawyerId , clientId, mapper.toModel(resource)));
    }

    @PreAuthorize("hasRole('INSTRUCTOR') or hasRole('ADMIN')")
    @PostMapping("{appointmentId}")
    public AppointmentResource updateAppointment(@PathVariable Long lawyerId,
                                                 @PathVariable Long clientId,
                                                 @PathVariable Long appointmentId,
                                                 @RequestBody UpdateAppointmentResource resource){
        return mapper.toResource(appointmentService.update(lawyerId, clientId, appointmentId, mapper.toModel(resource)));
    }

    @PreAuthorize("hasRole('INSTRUCTOR') or hasRole('ADMIN')")
    @PostMapping("{appointmentId}")
    public ResponseEntity<?> deleteAppointment(@PathVariable Long appointmentId,
                                               @PathVariable Long clientId,
                                               @PathVariable Long lawyerId)
}
