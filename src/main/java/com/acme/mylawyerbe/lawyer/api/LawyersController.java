package com.acme.mylawyerbe.lawyer.api;

import com.acme.mylawyerbe.lawyer.domain.service.LawyerService;
import com.acme.mylawyerbe.lawyer.mapping.LawyerMapper;
import com.acme.mylawyerbe.lawyer.resource.CreateLawyerResource;
import com.acme.mylawyerbe.lawyer.resource.LawyerResource;
import com.acme.mylawyerbe.lawyer.resource.UpdateLawyerResource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "api/v1/lawyers")
public class LawyersController {

    private final LawyerService lawyerService;

    private final LawyerMapper mapper;

    public LawyersController(LawyerService lawyerService, LawyerMapper mapper) {
        this.lawyerService = lawyerService;
        this.mapper = mapper;
    }

    @GetMapping
    public Page<LawyerResource> getAllLawyers(Pageable pageable){
        return mapper.modelListPage(lawyerService.getAll(), pageable);
    }

    @GetMapping("{lawyerId}")
    public  LawyerResource getLawyerId(Long lawyerId){
        return mapper.toResource(lawyerService.getById(lawyerId));
    }

    @PostMapping
    public ResponseEntity<LawyerResource> createLawyer(CreateLawyerResource resource){
        return new ResponseEntity<>(mapper.toResource(lawyerService.create(mapper.toModel(resource))), HttpStatus.CREATED);
    }

    @PutMapping("{lawyerId}")
    public LawyerResource updateLawyer(Long lawyerId, UpdateLawyerResource resource){
        return mapper.toResource(lawyerService.update(lawyerId, mapper.toModel(resource)));
    }

    @DeleteMapping("{lawyerId}")
    public ResponseEntity<?> deleteLawyer(Long lawyerId){
        return lawyerService.delete(lawyerId);
    }

}
