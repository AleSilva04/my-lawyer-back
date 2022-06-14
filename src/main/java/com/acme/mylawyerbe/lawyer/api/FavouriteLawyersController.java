package com.acme.mylawyerbe.lawyer.api;

import com.acme.mylawyerbe.lawyer.domain.service.FavouriteLawyerService;
import com.acme.mylawyerbe.lawyer.mapping.FavouriteLawyerMapper;
import com.acme.mylawyerbe.lawyer.resource.FavouriteLawyerResource;
import com.acme.mylawyerbe.lawyer.resource.CreateFavouriteLawyerResource;
import com.acme.mylawyerbe.lawyer.resource.UpdateFavouriteLawyerResource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/v1/favouriteLawyers")
public class FavouriteLawyersController {

    private final FavouriteLawyerService favouriteLawyerService;
    private final FavouriteLawyerMapper mapper;

    public FavouriteLawyersController(FavouriteLawyerService favouriteLawyerService, FavouriteLawyerMapper mapper) {
        this.favouriteLawyerService = favouriteLawyerService;
        this.mapper = mapper;
    }

    @GetMapping
    public Page<FavouriteLawyerResource> getAllStudents(Pageable pageable){
        return mapper.modelListPage(favouriteLawyerService.getAll(),pageable);
    }

    @PostMapping(value = "{clientId}/{lawyerId}")
    public ResponseEntity<FavouriteLawyerResource> createAppointment(@PathVariable Long clientId, @PathVariable Long lawyerId, CreateFavouriteLawyerResource resource){
        return new ResponseEntity<>(mapper.toResource(favouriteLawyerService.create(clientId, lawyerId, mapper.toModel(resource))), HttpStatus.CREATED);
    }

    @PutMapping("{favouriteLawyerId}")
    public FavouriteLawyerResource updateAppointment(@PathVariable Long favouriteLawyerId, UpdateFavouriteLawyerResource resource){
        return mapper.toResource(favouriteLawyerService.update(resource.getClient_id(), resource.getLawyer_id(), favouriteLawyerId, mapper.toModel(resource)));
    }

    @DeleteMapping("{favouriteLawyerId}/{clientId}/{lawyerId}")
    public ResponseEntity<?> deleteAppointment(@PathVariable Long clientId, @PathVariable Long lawyerId, @PathVariable Long favouriteLawyerId){
        return favouriteLawyerService.delete(clientId, lawyerId, favouriteLawyerId);
    }
}
