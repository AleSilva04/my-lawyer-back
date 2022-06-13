package com.acme.mylawyerbe.lawyer.resource;

import lombok.*;

@Getter
@Setter
@With
@NoArgsConstructor
@AllArgsConstructor
public class NotificationResource {
    private Long id;

    private String date;

    private Long clientId;

    private Long lawyerId;
}
