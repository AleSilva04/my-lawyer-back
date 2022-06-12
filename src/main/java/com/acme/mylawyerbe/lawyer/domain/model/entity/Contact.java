package com.acme.mylawyerbe.lawyer.domain.model.entity;

import com.acme.mylawyerbe.shared.domain.model.AuditModel;
import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@With
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "contacts")
public class Contact extends AuditModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //falta las relaciones
    // de 1 a muchos cliente a contact
    // de 1 a muchos lawyers a contact
}
