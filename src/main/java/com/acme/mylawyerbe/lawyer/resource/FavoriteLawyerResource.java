package com.acme.mylawyerbe.lawyer.resource;

import lombok.*;

@Getter
@Setter
@With
@NoArgsConstructor
@AllArgsConstructor
public class FavoriteLawyerResource {

    private Long id;

    private ClientResource clientResource;

    //Falta el private de lawyer
}