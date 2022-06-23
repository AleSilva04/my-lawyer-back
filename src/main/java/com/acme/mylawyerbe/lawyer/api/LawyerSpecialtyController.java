package com.acme.mylawyerbe.lawyer.api;

import com.acme.mylawyerbe.lawyer.domain.service.LawyerSpecialtyService;
import com.acme.mylawyerbe.lawyer.mapping.LawyerSpecialtyMapper;
import com.acme.mylawyerbe.lawyer.resource.LawyerSpecialtyResource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/lawyerSpecialty")
public class LawyerSpecialtyController {

    private final LawyerSpecialtyService lawyerSpecialtyService;

    private final LawyerSpecialtyMapper mapper;

    public LawyerSpecialtyController(LawyerSpecialtyService lawyerSpecialtyService, LawyerSpecialtyMapper mapper) {
        this.lawyerSpecialtyService = lawyerSpecialtyService;
        this.mapper = mapper;
    }

    @GetMapping
    public Page<LawyerSpecialtyResource> getAllLawyerSpecialties(Pageable pageable){
        return mapper.modelListPage(lawyerSpecialtyService.getAll(), pageable);
    }

}
