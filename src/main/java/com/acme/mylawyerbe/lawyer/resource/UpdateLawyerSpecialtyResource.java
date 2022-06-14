package com.acme.mylawyerbe.lawyer.resource;
import lombok.Setter;
import javax.validation.constraints.NotNull;

public class UpdateLawyerSpecialtyResource {
    @NotNull
    private int lawyerid;

    @NotNull
    private int specialtyid;

    private Long lawyerspecialtyid;
}
