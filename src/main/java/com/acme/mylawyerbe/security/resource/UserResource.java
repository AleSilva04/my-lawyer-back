package com.acme.mylawyerbe.security.resource;

import lombok.*;

import java.util.List;

@Getter
@Setter
@With
@AllArgsConstructor
@NoArgsConstructor
public class UserResource {
    private Long id;
    private String username;
    private String email;
    private List<RoleResource> roles;
}
