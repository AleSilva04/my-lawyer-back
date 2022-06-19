package com.acme.mylawyerbe.lawyer.api;

import com.acme.mylawyerbe.lawyer.domain.service.ClientService;
import com.acme.mylawyerbe.lawyer.mapping.ClientMapper;
import com.acme.mylawyerbe.lawyer.resource.ClientResource;
import com.acme.mylawyerbe.lawyer.resource.CreateClientResource;
import com.acme.mylawyerbe.lawyer.resource.UpdateClientResource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "api/v1/clients")
public class ClientsController {

    private final ClientService clientService;

    private final ClientMapper mapper;

    public ClientsController(ClientService clientService, ClientMapper mapper) {
        this.clientService = clientService;
        this.mapper = mapper;
    }

    @GetMapping
    public Page<ClientResource> getAllClients(Pageable pageable){
        return mapper.modelListPage(clientService.getAll(), pageable);
    }

    @GetMapping("{clientId}")
    public ClientResource getClientById(Long clientId){
        return mapper.toResource(clientService.getById(clientId));
    }

    @PostMapping
    public ResponseEntity<ClientResource> createClient(CreateClientResource resource){
        return new ResponseEntity<>(mapper.toResource(clientService.create(mapper.toModel(resource))), HttpStatus.CREATED);
    }

    @PutMapping("{clientId}")
    public ClientResource updateClient(Long clientId, UpdateClientResource resource){
        return mapper.toResource(clientService.update(clientId, mapper.toModel(resource)));
    }

    @DeleteMapping("{clientId}")
    public ResponseEntity<?> deleteClient(Long clientId){
        return clientService.delete(clientId);
    }

}
