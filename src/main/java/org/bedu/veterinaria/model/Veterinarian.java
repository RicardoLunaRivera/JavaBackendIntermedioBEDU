package org.bedu.veterinaria.model;

import java.time.LocalDateTime;
import java.util.Date;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

@Getter
@Setter
@ToString
@Entity
@Table (name= "veterinarians")
public class Veterinarian {
    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    @Column(name = "id_veterinarian")
    private Long idVeterinarian;

    @Column(length = 30)
    private String name;

    @Column(length = 30)
    private String lastname;

    @Column()
    private String schedule;

    @Column(nullable = false, length = 13)
    private String phone;

    @Column(length = 30)
    private String specialty;

    public String getNombreCompleto(){
        return name + " " + lastname;
    }
}