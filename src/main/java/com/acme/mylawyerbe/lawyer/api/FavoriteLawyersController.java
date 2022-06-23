package com.acme.mylawyerbe.lawyer.api;

import com.acme.mylawyerbe.lawyer.domain.service.FavoriteLawyerService;
import com.acme.mylawyerbe.lawyer.mapping.FavoriteLawyerMapper;
import com.acme.mylawyerbe.lawyer.resource.FavoriteLawyerResource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/favoriteLawyers")
public class FavoriteLawyersController {
    //TODO: revisar endpoints que esten correctamente escritos acorde al Frontend
    //TODO: revisar que metodos necesita las controller que son relaciones (aunque ya vi la clase y solo es esto)
    //TODO: creo que se crea un controller por cada relacion
    //TODO: falta los service implementation de los domain que tiene relaciones
    private final FavoriteLawyerService favoriteLawyerService;

    private final FavoriteLawyerMapper mapper;


    public FavoriteLawyersController(FavoriteLawyerService favoriteLawyerService, FavoriteLawyerMapper mapper) {
        this.favoriteLawyerService = favoriteLawyerService;
        this.mapper = mapper;
    }

    @GetMapping
    public Page<FavoriteLawyerResource> getAllFavoriteLawyers(Pageable pageable){
        return mapper.modelListPage(favoriteLawyerService.getAll(), pageable);
    }
}
