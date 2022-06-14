package com.acme.mylawyerbe.lawyer.resource;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;

@Getter
@Setter
public class UpdateAppointmentResource {

    @Temporal(TemporalType.TIMESTAMP)
    private Date date;

    private Long client_id;
    private Long lawyer_id;
}
