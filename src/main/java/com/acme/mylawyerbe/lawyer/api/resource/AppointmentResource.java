package com.acme.mylawyerbe.lawyer.api.resource;

import lombok.*;

import java.util.Date;

@Getter
@Setter
@With
@NoArgsConstructor
@AllArgsConstructor
public class AppointmentResource {

    private Long id;

    private Date date;

    private ClientResource clientResource;

    //Falta el private de lawyer
}
