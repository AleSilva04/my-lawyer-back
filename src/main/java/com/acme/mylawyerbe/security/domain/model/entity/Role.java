package com.acme.mylawyerbe.security.domain.model.entity;

import com.acme.mylawyerbe.security.domain.model.enumeration.Roles;
import com.acme.mylawyerbe.shared.domain.model.AuditModel;
import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@With
@Entity
@Table(name = "roles")
public class Role extends AuditModel {

    //2 atributos
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(length = 20)
    private Roles name;

}
