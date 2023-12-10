package org.bedu.veterinaria.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.mapstruct.Mapping;

import java.time.LocalDate;
import java.util.Date;
@Getter
@Setter
@ToString
@Entity
@Table(name = "mascotas") // Nombre de la tabla en la base de datos.

public class Pet {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idPet;

    @Column(nullable = false, length = 30)
    private String name;

    @Column(nullable = false, length = 30)
    private Species species;

    @Column(nullable = false, length = 30)
    private String race;

    @Column(nullable = false, length = 11)
    private String birthDate;

/*
    @ManyToOne(optional = false) // Relacion con la tabla Owner.
    @JoinColumn(name = "owner_id") // Nombre de la columna en la tabla Owner.
    private Owner owner;


    @OneToOne(optional = false) // Relacion con la tabla Veterinary.
    @JoinColumn(name = "id_veterinarian") // Nombre de la columna en la tabla Veterinary.
    private Veterinarian  IdVeterinarian;
    */
}
