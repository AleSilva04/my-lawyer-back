package com.acme.mylawyerbe.lawyer.domain.model.entity;

import com.acme.mylawyerbe.shared.domain.model.AuditModel;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
@With
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "lawyers")
public class Lawyer extends AuditModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @NotBlank
    @Size(max = 100)
    private String firstName;

    @NotNull
    @NotBlank
    @Size(max = 100)
    private String lastName;

    @Size(max = 240)
    private String address;

    private int age;

    @NotNull
    @NotBlank
    @Size(max = 240)
    @Column(unique = true)
    private String email; //es necesario colocarlo como un valor que no se repita, por eso ¿cómo hacerlo en la bd?

    private int points;

    @NotNull
    @NotBlank
    @Size(max = 240)
    private String image;

    private Long specialtyNumber; //número de colegiatura, ¿qué anotaciones puede tener?

    @Size(max = 240)
    private String businessOfWork; //empresa donde trabajo, esto si es opcional
}
