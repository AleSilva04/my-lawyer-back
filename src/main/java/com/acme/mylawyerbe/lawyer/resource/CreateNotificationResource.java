package com.acme.mylawyerbe.lawyer.resource;

import lombok.*;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
@With
@NoArgsConstructor
@AllArgsConstructor
public class CreateNotificationResource {

    @NotBlank
    @NonNull
    private String date;

    private Long clientId;

    private Long lawyerId;
}
