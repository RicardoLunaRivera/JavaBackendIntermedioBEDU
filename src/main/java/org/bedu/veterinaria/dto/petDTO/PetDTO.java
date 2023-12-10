package org.bedu.veterinaria.dto.petDTO;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.Data;
import org.bedu.veterinaria.model.Owner;
import org.bedu.veterinaria.model.Species;
import org.bedu.veterinaria.model.Veterinarian;

import java.time.LocalDate;
import java.util.Date;

@Data
public class PetDTO {
    @Schema(description = "Identificador de la mascota.", example = "1")
    private Long idPet;

    @Schema(description = "Nombre de la mascota.", example = "Bruce")
    private String name;

    @Schema(description = "Tipo de especie de la mascota.", example = "0 => PERRO")
    private Species species;

    @Schema(description = "Raza de la mascota", example = "Pug")
    private String race;

    @Schema(description = "Fecha de nacimiento de la mascota.", example = "2023-05-18")
    private String birthDate;

    @Schema(description = "Identificador del dueño de la mascota.", example = "1")
    private Long ownerId;
/*
    @Schema(description = "Identificador del veterinario que atenderá a la mascota.", example = "4")
    private Veterinarian idVeterinarian;

 */
}
