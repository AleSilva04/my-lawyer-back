package com.acme.mylawyerbe.lawyer.resource;
import lombok.*;

import javax.persistence.Column;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
@With
@NoArgsConstructor
@AllArgsConstructor
public class CreateLawyerSpecialtyResource {
    @NotNull
    private int lawyerid;

    @NotNull
    private int specialtyid;
}
