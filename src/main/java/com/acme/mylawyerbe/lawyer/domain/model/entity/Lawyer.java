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
@Table(name = "lawyers")
public class Lawyer extends AuditModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @NotBlank
    @Size(max = 100)
    private String fullName;

    @NotNull
    @NotBlank
    @Size(max = 240)
    private String address;

    @NotNull
    private int age;

    @NotNull
    @NotBlank
    @Size(max = 240)
    @Column(unique = true)
    private String email; //es necesario colocarlo como un valor que no se repita, por eso ¿cómo hacerlo en la bd?

    @NotNull
    private int points;

    @NotNull
    @NotBlank
    @Size(max = 240)
    private String image;

    public Lawyer(String fullName, String address, int age, String email, int points, String image) {
        this.fullName = fullName;
        this.address = address;
        this.age = age;
        this.email = email;
        this.points = points;
        this.image = image;
    }

    @Override
    public String toString(){
        return "Lawyer{" +
                "id=" + this.id +
                ", fullName='" + this.fullName + "'" +
                ", address='" + this.address + "'" +
                ", email='" + this.email + "'" +
                ", age='" + this.age + "'" +
                ", points='" + this.points + "'" +
                ", image='" + this.image + "'" +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
