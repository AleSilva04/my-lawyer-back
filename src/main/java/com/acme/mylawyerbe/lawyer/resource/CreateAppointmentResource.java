package com.acme.mylawyerbe.lawyer.resource;

import lombok.*;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;

@Getter
@Setter
@With
@NoArgsConstructor
@AllArgsConstructor
public class CreateAppointmentResource {

    @Temporal(TemporalType.TIMESTAMP)
    private Date date;
}
