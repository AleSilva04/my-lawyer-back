package com.acme.mylawyerbe.lawyer.domain.model.entity;


import com.acme.mylawyerbe.shared.domain.model.AuditModel;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@With
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "favorite_lawyers")
public class FavouriteLawyer extends AuditModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "client_id", nullable = false)
    @JsonIgnore
    private Client client;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "lawyer_id", nullable = false)
    @JsonIgnore
    private Lawyer lawyer;


}
