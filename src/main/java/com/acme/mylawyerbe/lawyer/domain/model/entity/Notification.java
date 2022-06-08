package com.acme.mylawyerbe.lawyer.domain.model.entity;

import com.acme.mylawyerbe.shared.domain.model.AuditModel;
import lombok.*;

import javax.persistence.*;
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

    private Date date; //tiene alguna validación

    //falta las relaciones
    //clientId
    //lawyerId
    //con el atributo "createdAt" es suficiente?
}
