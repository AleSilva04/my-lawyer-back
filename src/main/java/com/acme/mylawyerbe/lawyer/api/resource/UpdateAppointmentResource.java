package com.acme.mylawyerbe.lawyer.api.resource;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class UpdateAppointmentResource {

    private Date date;

    private Long client_id;

    //falta "private Long lawyer_id;"
}
