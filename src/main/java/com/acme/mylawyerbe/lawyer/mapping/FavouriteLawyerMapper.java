package com.acme.mylawyerbe.lawyer.mapping;

import com.acme.mylawyerbe.lawyer.domain.model.entity.FavouriteLawyer;
import com.acme.mylawyerbe.lawyer.resource.FavouriteLawyerResource;
import com.acme.mylawyerbe.lawyer.resource.CreateFavouriteLawyerResource;
import com.acme.mylawyerbe.lawyer.resource.UpdateFavouriteLawyerResource;
import com.acme.mylawyerbe.shared.mapping.EnhancedModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import java.util.List;

public class FavouriteLawyerMapper {

    @Autowired
    EnhancedModelMapper mapper;

    public FavouriteLawyerResource toResource(FavouriteLawyer model){
        return mapper.map(model, FavouriteLawyerResource.class);
    }

    public Page<FavouriteLawyerResource> modelListPage(List<FavouriteLawyer> modelList, Pageable pageable)
    {
        return new PageImpl<>(mapper.mapList(modelList, FavouriteLawyerResource.class), pageable, modelList.size()) ;
    }

    public FavouriteLawyer toModel(CreateFavouriteLawyerResource resource){

        return mapper.map(resource, FavouriteLawyer.class);
    }

    public FavouriteLawyer toModel(UpdateFavouriteLawyerResource resource){

        return mapper.map(resource, FavouriteLawyer.class);
    }
}
