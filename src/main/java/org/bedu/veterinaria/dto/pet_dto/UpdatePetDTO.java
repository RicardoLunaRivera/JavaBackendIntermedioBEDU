package org.bedu.veterinaria.dto.pet_dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.bedu.veterinaria.model.Species;

import java.util.Date;

@Data
public class UpdatePetDTO {
    @Schema(description = "Nombre de la mascota.", example = "Bruce")
    @NotEmpty(message = "El nombre de la mascota a actualizar no puede ir vacío.")
    private String name;

    @Schema(description = "Tipo de especie de la mascota a actualizar.", example = "0 => PERRO")
    @NotNull(message = "Debe ingresar la especie de la mascota a actualizar.")
    private Species species;

    @Schema(description = "Raza de la mascota", example = "Pug")
    @NotEmpty(message = "Debe indicar la raza de la mascota a actualizar.")
    private String race;

    @Schema(description = "Fecha de nacimiento de la mascota.", example = "2023-05-18")
    @NotNull(message = "La fecha de nacimiento de la mascota no puede ir vacia.")
    private Date birthDate;

    @Schema(description = "Identificador del dueño de la mascota.", example = "1")
    @NotNull(message = "Debe indicar el ID del Dueño de la mascota.")
    private Long ownerId;

    @Schema(description = "Identificador del veterinario que atenderá a la mascota.", example = "4")
    @NotNull(message = "Debe indicar el ID del veterinario que atenderá a la mascota.")
    private Long veterinarianId;

    public void setBirthDate(String date) {
        // Metodo creado para pruebas unitarias
    }
}
