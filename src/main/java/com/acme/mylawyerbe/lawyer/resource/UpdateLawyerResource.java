package com.acme.mylawyerbe.lawyer.resource;

import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class UpdateLawyerResource {
    @NotNull
    @NotBlank
    @Size(max = 100)
    private String fullName;

    @NotNull
    @NotBlank
    @Size(max = 240)
    private String address;

    @NotNull
    private int age;

    @NotNull
    @NotBlank
    @Size(max = 240)
    @Column(unique = true)
    private String email; //es necesario colocarlo como un valor que no se repita, por eso ¿cómo hacerlo en la bd?

    @NotNull
    private int points;

    @NotNull
    @NotBlank
    @Size(max = 240)
    private String image;

    private Long id;
}
