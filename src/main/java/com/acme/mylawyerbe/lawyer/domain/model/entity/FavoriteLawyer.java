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
@Table(name = "favoriteLawyers")
public class FavoriteLawyer extends AuditModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //falta las relaciones
    // de 1 a muchos cliente a Favorite
    // de 1 a muchos lawyers a Favorite
}
