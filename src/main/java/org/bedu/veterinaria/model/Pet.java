package org.bedu.veterinaria.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;
/*
@Getter
@Setter
@ToString
@Entity
@Table(name = "mascotas") // Nombre de la tabla en la base de datos.

 */
public class Pet {
    /*
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idPet;

    @Column(nullable = false, length = 30)
    private String name;

    @Enumerated(EnumType.STRING) // Para que el enum se convierta en un string en la base de datos.
    @Column(nullable = false, length = 30)
    private Species species;

    @Column(nullable = false, length = 30)
    private String race;

    @JsonFormat(pattern="yyyy-MM-dd") // Para que la fecha se convierta en un string en la base de datos.
    private Date birthDate;

    @ManyToOne(optional = false) // Relacion con la tabla Owner.
    @JoinColumn(name = "id_owner") // Nombre de la columna en la tabla Owner.
    private Owner owner;


    @OneToOne(optional = false) // Relacion con la tabla Veterinary.
    @JoinColumn(name = "id_veterinary") // Nombre de la columna en la tabla Veterinary.
    private Veterinary  veterinary;

     */
}
