package com.acme.mylawyerbe.lawyer.domain.model.entity;

import com.acme.mylawyerbe.shared.domain.model.AuditModel;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.sql.Timestamp;

@Getter
@Setter
@With
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "lawyerspecialty")
public class LawyerSpecialty extends AuditModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long lawyerspecialtyid;

    @NotNull
    private int lawyerid;

    @NotNull
    private int specialtyid;


    public LawyerSpecialty(int lawyerid, int specialtyid) {
        this.lawyerid = lawyerid;
        this.specialtyid = specialtyid;
    }

    @Override
    public String toString(){
        return "LawyerSpecialty{" +
                "lawyerspecialtyid=" + this.lawyerspecialtyid +
                "lawyerid=" + this.lawyerid +
                "specialtyid=" + this.specialtyid +
                '}';
    }

    public Long getId() {
        return lawyerspecialtyid;
    }

    public void setId(Long id) {
        this.lawyerspecialtyid = lawyerspecialtyid;
    }


    public int getLawyerId() {
        return lawyerid;
    }

    public void setLawyerId(int lawyerid) {
        this.lawyerid = lawyerid;
    }

    public int getSpecialtyId() {
        return specialtyid;
    }

    public void setSpecialtyId(int specialtyid) {
        this.specialtyid = specialtyid;
    }
}