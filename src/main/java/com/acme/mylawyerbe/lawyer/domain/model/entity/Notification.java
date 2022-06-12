package com.acme.mylawyerbe.lawyer.domain.model.entity;

import com.acme.mylawyerbe.shared.domain.model.AuditModel;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

@Getter
@Setter
@With
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "notifications")
public class Notification extends AuditModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Date date; //tiene alguna validación??

    @NotNull
    @NotBlank
    @Size(max = 240)
    private String message;

    //falta las relaciones
    //clientId
    //lawyerId
    //con el atributo "createdAt" es suficiente?
}
