package com.acme.mylawyerbe.lawyer.resource;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Setter
@Getter
public class UpdateNotificationResource {

    private Long id;

    @NotBlank
    @NotNull
    private String date;

    private Long clientId;

    private Long lawyerId;
}
