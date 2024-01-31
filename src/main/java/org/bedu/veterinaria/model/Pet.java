package org.bedu.veterinaria.model;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

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

    @Column(name = "birth_date")
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date birthDate;

    @ManyToOne// Relacion con la tabla Owner.
    @JoinColumn(name="id_owner")
    //@JoinColumn(name = "owner_id", referencedColumnName = "id_owner") // Nombre de la columna en la tabla Owner [ONE TO ONE]
    private Owner owner;


    @ManyToOne// Relacion con la tabla Veterinary.
    @JoinColumn(name = "id_veterinarian") // Nombre de la columna en la tabla Veterinary.
    //@JoinColumn(name = "veterinarian_id", referencedColumnName = "id_veterinarian")[ONE TO ONE]
    private Veterinarian veterinarian;

}
