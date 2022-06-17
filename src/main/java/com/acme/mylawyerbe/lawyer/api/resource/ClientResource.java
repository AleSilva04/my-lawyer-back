package com.acme.mylawyerbe.lawyer.api.resource;

import com.acme.mylawyerbe.lawyer.domain.model.entity.Client;
import com.acme.mylawyerbe.shared.mapping.EnhancedModelMapper;
import lombok.*;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@With
@NoArgsConstructor
@AllArgsConstructor
public class ClientResource implements Serializable {

    private Long id;

    private String firstName;

    private String lastName;

    private String address;

    private int age;

    private String email;
}