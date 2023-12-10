package org.bedu.veterinaria.dto.petDTO;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.bedu.veterinaria.model.Owner;
import org.bedu.veterinaria.model.Species;
import org.bedu.veterinaria.model.Veterinarian;

import java.util.Date;

@Data
public class DeletePetDTO {

    @Id
    private Long idPet;

    @Schema(description = "Nombre de la mascota.", example = "Bruce")
    @NotEmpty(message = "El nombre de la mascota no puede ir vacío.")
    private String name;

    @Schema(description = "Tipo de especie de la mascota.", example = "0 => PERRO")
    @NotEmpty(message = "Debe ingresar la especie de la mascota.")
    private Species species;

    @Schema(description = "Raza de la mascota", example = "Pug")
    @NotEmpty(message = "Debe indicar la raza de la mascota.")
    private String race;

    @Schema(description = "Fecha de nacimiento de la mascota.", example = "2023-05-18")
    @NotEmpty(message = "La fecha de nacimiento de la mascota no puede ir vacia.")
    private String birthDate;

    @Schema(description = "Identificador del dueño de la mascota.", example = "1")
    @NotNull(message = "Debe indicar el ID del Dueño de la mascota.")
    private Long ownerId;

    @Schema(description = "Identificador del veterinario que atenderá a la mascota.", example = "4")
    @NotNull(message = "Debe indicar el ID del veterinario que atenderá a la mascota.")
    private Long veterinarianId;

}
