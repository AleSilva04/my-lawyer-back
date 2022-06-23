package com.acme.mylawyerbe.lawyer.api;

import com.acme.mylawyerbe.lawyer.domain.service.SpecialtyService;
import com.acme.mylawyerbe.lawyer.mapping.SpecialtyMapper;
import com.acme.mylawyerbe.lawyer.resource.CreateSpecialtyResource;
import com.acme.mylawyerbe.lawyer.resource.SpecialtyResource;
import com.acme.mylawyerbe.lawyer.resource.UpdateSpecialtyResource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "api/v1/specialties")
public class SpecialtiesController {

    private final SpecialtyService specialtyService;

    private final SpecialtyMapper mapper;

    public SpecialtiesController(SpecialtyService specialtyService, SpecialtyMapper mapper) {
        this.specialtyService = specialtyService;
        this.mapper = mapper;
    }

    @GetMapping
    public Page<SpecialtyResource> getAllSpecialties(Pageable pageable){
        return mapper.modelListPage(specialtyService.getAll(), pageable);
    }

    @GetMapping("{specialtyId}")
    public SpecialtyResource getSpecialtyById(Long specialtyId){
        return mapper.toResource(specialtyService.getById(specialtyId));
    }

    @PostMapping
    public ResponseEntity<SpecialtyResource> createSpecialty(CreateSpecialtyResource resource){
        return new ResponseEntity<>(mapper.toResource(specialtyService.create(mapper.toModel(resource))), HttpStatus.CREATED);
    }

    @PutMapping("{specialtyId}")
    public SpecialtyResource updateSpecialty(Long specialtyId, UpdateSpecialtyResource resource){
        return mapper.toResource(specialtyService.update(specialtyId, mapper.toModel(resource)));
    }

    @DeleteMapping("{specialtyId}")
    public ResponseEntity<?> deleteSpecialty(Long specialtyId){
        return specialtyService.delete(specialtyId);
    }

}
